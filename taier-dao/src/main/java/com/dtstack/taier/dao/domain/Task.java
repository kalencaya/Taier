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

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@TableName("develop_task")
public class Task {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属工作流id
     */
    private Long flowId;
    /**
     * '任务名称'
     */
    private String name;

    /**
     * '计算类型 0实时，1 离线'
     */
    private Integer computeType;

    /**
     * 'sql 文本'
     */
    private String sqlText;

    /**
     * '任务参数'
     */
    private String taskParams;

    /**
     * 执行参数
     */
    private String exeArgs;

    /**
     * 最后修改task的用户
     */
    @TableField("modify_user_id")
    private Long modifyUserId;

    @TableField("create_user_id")
    private Long createUserId;

    /**
     * 'task版本'
     */
    private Integer version;

    /**
     * 组件版本：此处对应流计算任务而言就是 flink 版本
     */
    private String componentVersion;

    /**
     * 所在目录
     */
    private Long nodePid;

    /**
     * 任务描述
     */
    private String taskDesc;

    /**
     * 0 向导模式  1 脚本模式
     */
    private Integer createModel;

    private String sourceStr;

    private String targetStr;

    private String sideStr;

    private String settingStr;

    /**
     * 调度配置 json格式
     */
    private String scheduleConf;

    /**
     * 周期类型
     */
    private Integer periodType;

    /**
     * 0未开始,1正常调度,2暂停
     */
    private Integer scheduleStatus;

    /**
     * 任务类型 @see EScheduleJobType
     */
    private Integer taskType;

    /**
     * 任务状态默认等待提交状态
     *
     * @See TaskSubmitStatusEnum
     */
    private Integer submitStatus;

    private String mainClass;

    private String queueName;

    private Timestamp gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE, update = "now()", value = "gmt_modified")
    private Timestamp gmtModified;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;

    @TableField("tenant_id")
    private Long tenantId;

    private String jobId;

    @TableField("datasource_id")
    private Long datasourceId;
}