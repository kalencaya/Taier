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
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@TableName("develop_task_version")
public class TaskVersion {

    /**
     * 任务 ID
     */
    @TableField("task_id")
    private Long taskId;

    /**
     * 'sql 文本'
     */
    @TableField("sql_text")
    private String sqlText;

    /**
     * 'sql 文本'
     */
    @TableField("origin_sql")
    private String originSql;

    /**
     * 'sql 文本'
     */
    @TableField("publish_desc")
    private String publishDesc;

    /**
     * 新建task的用户
     */
    @TableField("create_user_id")
    private Long createUserId;

    /**
     * 'task版本'
     */
    @TableField("version")
    private Integer version;

    /**
     * 组件版本：此处对应流计算任务而言就是 flink 版本
     */
    @TableField(exist = false)
    private String componentVersion;

    /**
     * 任务描述
     */
    @TableField(exist = false)
    private String taskDesc;

    /**
     * 0 向导模式  1 脚本模式
     */
    @TableField(exist = false)
    private Integer createModel;

    @TableField(exist = false)
    private String sourceStr;

    @TableField(exist = false)
    private String targetStr;

    @TableField(exist = false)
    private String settingStr;

    /**
     * 环境参数
     */
    @TableField("task_params")
    private String taskParams;

    /**
     * 执行参数
     */
    @TableField(exist = false)
    private String exeArgs;

    /**
     * 调度配置 json格式
     */
    @TableField("schedule_conf")
    private String scheduleConf;

    /**
     * 周期类型
     */
    @TableField(exist = false)
    private Integer periodType;

    /**
     * 0未开始,1正常调度,2暂停
     */
    @TableField("schedule_status")
    private Integer scheduleStatus;
    /**
     * 依赖的任务id
     */
    @TableField("dependency_task_ids")
    private String dependencyTaskIds;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id = 0L;

    @TableField("is_deleted")
    private Integer isDeleted = 0;

    /**
     * 租户Id
     */
    @TableField("tenant_id")
    private Long tenantId;

    /**
     * 实体创建时间
     */
    @TableField(
            value = "gmt_create",
            fill = FieldFill.INSERT
    )
    private Timestamp gmtCreate;
    /**
     * 实体修改时间
     */
    @TableField(
            value = "gmt_modified",
            fill = FieldFill.INSERT_UPDATE
    )
    private Timestamp gmtModified;
}