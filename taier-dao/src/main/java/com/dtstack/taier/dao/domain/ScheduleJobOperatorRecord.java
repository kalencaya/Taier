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
import java.util.Date;

@Data
@TableName("schedule_job_operator_record")
public class ScheduleJobOperatorRecord {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 实例id
     */
    private String jobId;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 操作过期时间
     */
    private Date operatorExpired;

    /**
     * 操作类型 0杀死 1重跑 2 补数据
     */
    private Integer operatorType;

    /**
     * 强制标志 0非强制 1强制
     */
    private Integer forceCancelFlag;

    /**
     * 节点地址
     */
    private String nodeAddress;

    /**
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 最近修改的时间
     */
    private Timestamp gmtModified;

    /**
     * 0正常 1逻辑删除
     */
    private Integer isDeleted;
}
