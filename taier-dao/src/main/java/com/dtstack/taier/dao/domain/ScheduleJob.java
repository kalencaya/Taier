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

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("schedule_job")
public class ScheduleJob implements Serializable {

    /**
     * 实例唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 实例id
     */
    private String jobId;

    /**
     * jobKey
     */
    private String jobKey;

    /**
     * 实例名称
     */
    private String jobName;

    /**
     * 任务名称
     */
    private Long taskId;

    /**
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    private Timestamp gmtModified;

    /**
     * 创建人id
     */
    private Long createUserId;

    /**
     * 是否逻辑删除
     */
    private Integer isDeleted;

    /**
     * 任务类型： 0 周期实例，1补数据 2 立即运行
     */
    private Integer type;

    /**
     * 是否重试
     */
    private Integer isRestart;

    /**
     * 计划时间
     */
    private String cycTime;

    /**
     * 依赖类型
     */
    private Integer dependencyType;

    /**
     * 工作流目标节点
     */
    private String flowJobId;

    /**
     * 调度类型
     * 分钟:MIN(0),
     * 小时:HOUR(1),
     * 天:DAY(2),
     * 周:WEEK(3),
     * 月:MONTH(4),
     * 自定义cron表达式:CRON(5)
     */
    private Integer periodType;

    /**
     * 实例状态
     */
    private Integer status;

    /**
     * 任务类型：
     * 虚节点:VIRTUAL(-)1,
     * SparkSQL:SPARK_SQL(0),
     * Spark:SPARK(1),
     * 数据同步:SYNC(2),
     * Shell: SHELL(3),
     * 工作流:WORK_FLOW(1)
     */
    private Integer taskType;

    /**
     * 补数据id
     */
    private Long fillId;

    /**
     * 实际开始时间
     */
    private Timestamp execStartTime;

    /**
     * 实际结束时间
     */
    private Timestamp execEndTime;

    /**
     * 运行时长
     */
    private Long execTime;

    /**
     * 最大重试次数
     */
    private Integer maxRetryNum;

    /**
     * 当前重试次数
     */
    private Integer retryNum;

    /**
     * 运行实例的ip
     */
    private String nodeAddress;

    /**
     * 实例版本
     */
    private Integer versionId;

    /**
     * 下一个实例计划运行时间
     */
    private String nextCycTime;

    /**
     * yarn运行实例id
     */
    private String engineJobId;

    /**
     * 应用id
     */
    private String applicationId;

    /**
     * 计算类型
     */
    private Integer computeType;

    /**
     * 阶段类型
     */
    private Integer phaseStatus;

    /**
     * 排序
     */
    private Long jobExecuteOrder;


    /**
     * 补数据实例状态：0 默认值 周期实例，立即运行等非补数据实例的默认值 1 可执行补数据实例 2 中间实例
     */
    private Integer fillType;

    /**
     * 任务提交的用户名称
     */
    private String submitUserName;
}
