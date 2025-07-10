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

package com.dtstack.taier.develop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dtstack.taier.common.security.NoExitSecurityManager;
import com.dtstack.taier.common.util.JavaPolicyUtils;
import com.dtstack.taier.common.util.ShutdownHookUtil;
import com.dtstack.taier.common.util.SystemPropertyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
public class TaierApplication {

    public static void main(String[] args) {
        try {
            SystemPropertyUtil.setSystemUserDir();
            JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
            SpringApplication application = new SpringApplication(TaierApplication.class);
            application.run(args);
            System.setSecurityManager(new NoExitSecurityManager());
            ShutdownHookUtil.addShutdownHook(TaierApplication::shutdown, TaierApplication.class.getSimpleName(), log);
            JavaPolicyUtils.checkJavaPolicy();
        } catch (Throwable t) {
            log.error("start error:", t);
            System.exit(-1);
        } finally {
            log.info("taier start end...");
        }
    }

    private static void shutdown() {
        log.info("taier is shutdown...");
    }

}