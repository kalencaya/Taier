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
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@TableName("schedule_job_job")
public class ScheduleJobJob {

    /**
     * 唯一标识
     */
    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 实例key
     */
    private String jobKey;

    /**
     * 父实例key
     */
    private String parentJobKey;

    /**
     * parentJobKey类型： RelyType
     *   1. 自依赖实例key
     *   2. 上游任务key
     *   3. 上游任务的下一个周期key
     */
    private Integer jobKeyType;

    /**
     * 依赖规则: RelyRule
     *  1. 父实例运行完成，可以运行
     *  2. 父实例运行成功，可以运行
     */
    private Integer rule;

    /**
     * 生成时间
     */
    private Timestamp gmtCreate;

    /**
     * 最近一次修改的时间
     */
    private Timestamp gmtModified;

    /**
     * 是否逻辑删除
     */
    private Integer isDeleted;
}
