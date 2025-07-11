/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.taier.common;

import com.dtstack.taier.common.thread.SignRunnable;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.concurrent.*;
import java.util.function.Consumer;

@Slf4j
public class CustomThreadRunsPolicy<T> implements RejectedExecutionHandler {

    private String threadName;

    private String type;

    private int timeout = 60;

    private Consumer<T> callBack;

    public CustomThreadRunsPolicy(String threadName, String type) {
        this.threadName = threadName;
        this.type = type;
    }

    public CustomThreadRunsPolicy(String threadName, String type, int timeout) {
        this.threadName = threadName;
        this.type = type;
        this.timeout = timeout;
    }


    public CustomThreadRunsPolicy(String threadName, String type, int timeout, Consumer<T> callback) {
        this.threadName = threadName;
        this.type = type;
        this.timeout = timeout;
        this.callBack = callback;
    }

    public CustomThreadRunsPolicy(String threadName, String type, Consumer<T> callback) {
        this.threadName = threadName;
        this.type = type;
        this.callBack = callback;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        String msg = String.format("Thread pool is EXHAUSTED!" +
                        " Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), Task: %d (completed: %d)," +
                        " Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s), in type:%s!",
                threadName, e.getPoolSize(), e.getActiveCount(), e.getCorePoolSize(), e.getMaximumPoolSize(), e.getLargestPoolSize(),
                e.getTaskCount(), e.getCompletedTaskCount(), e.isShutdown(), e.isTerminated(), e.isTerminating(),
                type);
        try {
            log.warn(msg);
            boolean offer = e.getQueue().offer(r, timeout, TimeUnit.SECONDS);
            if (!offer && null != callBack) {
                getSignAndCallBack(r, callBack);
            }
            log.warn("offer {}", offer);
        } catch (InterruptedException interruptedException) {
            log.error(msg);
            throw new RejectedExecutionException("Interrupted waiting for worker");
        }
    }


    public <T> T getSignAndCallBack(Runnable runnable, Consumer<T> callBack) {
        try {
            boolean isFutureTask = runnable instanceof FutureTask;
            if (!isFutureTask) {
                return null;
            }
            Field callableField = FutureTask.class.getDeclaredField("callable");
            callableField.setAccessible(true);
            Object callableObj = callableField.get(runnable);
            Class<?>[] declaringClass = Executors.class.getDeclaredClasses();
            for (Class<?> clazz : declaringClass) {
                if (clazz.getName().equals("java.util.concurrent.Executors$RunnableAdapter")) {
                    Field task = clazz.getDeclaredField("task");
                    task.setAccessible(true);
                    Object runnableObj = task.get(callableObj);
                    if (runnableObj instanceof SignRunnable) {
                        SignRunnable<T> signRunnable = (SignRunnable) runnableObj;
                        T sign = signRunnable.getSign();
                        callBack.accept(sign);
                    }
                }
            }
        } catch (Exception e) {
            log.error("getSign error callback", e);
        }
        return null;
    }
}