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
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("schedule_task_shade")
public class ScheduleTaskShade implements Serializable {

    /**
     * 唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 任务名称
     */
    private String name;

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
     * 计算类型： 0 批处理，1 流处理
     */
    private Integer computeType;

    /**
     * 存储sql字段
     */
    private String sqlText;

    /**
     * 任务环境参数
     */
    private String taskParams;

    /**
     * 离线任务id
     */
    private Long taskId;

    /**
     * 调度规则
     */
    private String scheduleConf;

    /**
     * 调度的任务类型:
     * 分钟:MIN(0),
     * 小时:HOUR(1),
     * 天:DAY(2),
     * 周:WEEK(3),
     * 月:MONTH(4),
     * 自定义cron表达式:CRON(5)
     */
    private Integer periodType;

    /**
     * 调度状态：0 正常 1冻结 2停止
     */
    private Integer scheduleStatus;

    /**
     * 生成日期
     */
    private Timestamp gmtCreate;

    /**
     * 最近一次修改日期
     */
    private Timestamp gmtModified;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 最近一次修改人id
     */
    private Long modifyUserId;


    /**
     * 任务运行参数
     */
    @TableField(exist = false)
    private String extraInfo;

    /**
     * 版本id
     */
    private Integer versionId;

    /**
     * 是否逻辑删除
     */
    private Integer isDeleted;

    /**
     * 任务备注
     */
    private String taskDesc;

    /**
     * 工作流id
     */
    private Long flowId;

    /**
     * 任务组件版本
     */
    private String componentVersion;

    /**
     * yarn 队列名称
     */
    private String queueName;

    private Long datasourceId;
}
