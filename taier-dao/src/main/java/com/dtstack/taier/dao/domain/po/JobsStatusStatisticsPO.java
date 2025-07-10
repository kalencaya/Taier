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

package com.dtstack.taier.dao.domain.po;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobsStatusStatisticsPO {

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 用户ID 责任人
     */
    private Long userId;

    /**
     * 计划开始时间
     **/
    private String cycStartTime;

    /**
     * 计划结束时间
     **/
    private String cycEndTime;

    /**
     * 任务id
     */
    private List<Long> taskIdList;

    /**
     * 任务类型
     */
    private List<Integer> taskTypeList;

    /**
     * 状态
     */
    private List<Integer> jobStatusList;

    /**
     * 调度周期类型
     */
    private List<Integer> taskPeriodTypeList;

    /**
     * 补数据类型
     */
    private List<Integer> FillTypeList;

    /**
     * 实例类型 周期实例：0, 补数据实例:1;
     */
    private Integer type;

    /**
     * 补数据id
     */
    private Long fillId;
}
