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
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@TableName("schedule_fill_data_job")
public class ScheduleFillDataJob implements Serializable {

    /**
     * 补数据id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 补数据名称
     */
    private String jobName;

    /**
     * 生成时间
     */
    private String runDay;

    /**
     * 补数据开始运行时间
     */
    private String fromDay;

    /**
     * 补数据结束时间
     */
    private String toDay;

    /**
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 最新修改时间
     */
    private Timestamp gmtModified;

    /**
     * 发起操作的用户
     */
    private Long createUserId;

    /**
     * 是否逻辑删除
     */
    private Integer isDeleted;

    /**
     * 补数据上下文
     */
    private String fillDataInfo;

    /**
     * 补数据状态
     */
    private Integer fillGenerateStatus;
}
