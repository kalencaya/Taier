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

package com.dtstack.taier.dao.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ScheduleJobDTO {

    private List<Integer> jobStatuses;
    private String taskNameLike;
    private String businessDateLike;

    /**执行耗费时间**/
    private Long execTime;
    private String jobNameRightLike;
    private List<Long> taskIds;
    private Timestamp startGmtCreate;
    private Timestamp endGmtCreate;
    private Long taskCreateId;
    private List<Integer> taskTypes;
    private String execTimeSort;

    /**执行开始时间**/
    private String execStartSort;

    /**执行结束时间**/
    private String execEndSort;
    private String cycSort;
    private String retryNumSort;
    private String businessDateSort;
    private List<Integer> taskPeriodId;//任务周期列表
    private String bizStartDay;
    private String bizEndDay;
    /**调度开始日期**/
    private String cycStartDay;

    /**调度结束日期**/
    private String cycEndDay;
    private Long ownerUserId;
    private boolean pageQuery;

    /**查询工作流模式，  1.排除工作流子节点 2.只查询工作流子节点 3.父子节点都有查 4.排除工作流父节点 **/
    private Integer queryWorkFlowModel;
    private String fillDataJobName;
    private Integer  searchType;
    /**
     * fixme 算法实验任务实例Id
     */
    private List<String> labFlowJobIdList;

    /**
     * 是否查询子节点的任务类型
     */
    private boolean needQuerySonNode;

    private String likeBusinessDate;

    private Integer currentPage;

    private Integer pageSize;

    private Date execStartDay;

    private Date execEndDay;

    private List<Integer> types;
}
