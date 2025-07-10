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

package com.dtstack.taier.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("schedule_job_cache")
public class ScheduleJobCache {

    /**
     * 唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 周期实例id
     */
    private String jobId;

    /**
     * 实例名称
     */
    private String jobName;

    /**
     * 计算类型stream/batch
     */
    private Integer computeType;

    /**
     * 处于master等待队列：1 还是exe等待队列 2
     */
    private Integer stage;

    /**
     * job信息
     */
    private String jobInfo;

    /**
     * 节点地址
     */
    private String nodeAddress;

    /**
     * job的计算引擎资源类型
     */
    private String jobResource;

    /**
     * 任务优先级
     */
    private Long jobPriority;

    /**
     * 0：不是，1：由故障恢复来的任务
     */
    private Integer isFailover;

    /**
     * 任务等待原因
     */
    private String waitReason;

    /**
     * 租户 id
     */
    private Long tenantId;

    /**
     * 新增时间
     */
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    private Timestamp gmtModified;

    /**
     * 0正常 1逻辑删除
     */
    private Integer isDeleted;
}
