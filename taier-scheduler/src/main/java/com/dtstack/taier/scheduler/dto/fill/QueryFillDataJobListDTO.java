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

package com.dtstack.taier.scheduler.dto.fill;

import javax.validation.constraints.NotNull;
import java.util.List;

public class QueryFillDataJobListDTO {

    /**
     * 补数据id
     */
    @NotNull(message = "fillId is not null")
    private Long fillId;

    /**
     * 租户id
     */
    @NotNull(message = "tenantId is not null")
    private Long tenantId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 计算开始时间
     */
    private Long cycStartDay;

    /**
     * 计算结束时间
     */
    private Long cycEndDay;

    /**
     * 用户ID 责任人
     */
    private Long operatorId;

    /**
     * 任务类型
     */
    private List<Integer> taskTypeList;

    /**
     * 状态
     */
    private List<Integer> jobStatusList;

    /**
     * 按计划时间排序
     */
    private String cycSort;

    /**
     * 按运行时长排序
     */
    private String execTimeSort;

    /**
     * 按开始时间排序
     */
    private String execStartSort;

    /**
     * 结束时间
     */
    private String execEndSort;


    /**
     * 按重试次数排序
     */
    private String retryNumSort;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 页码
     */
    private Integer pageSize;

    public Long getFillId() {
        return fillId;
    }

    public void setFillId(Long fillId) {
        this.fillId = fillId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getCycStartDay() {
        return cycStartDay;
    }

    public void setCycStartDay(Long cycStartDay) {
        this.cycStartDay = cycStartDay;
    }

    public Long getCycEndDay() {
        return cycEndDay;
    }

    public void setCycEndDay(Long cycEndDay) {
        this.cycEndDay = cycEndDay;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public List<Integer> getTaskTypeList() {
        return taskTypeList;
    }

    public void setTaskTypeList(List<Integer> taskTypeList) {
        this.taskTypeList = taskTypeList;
    }

    public List<Integer> getJobStatusList() {
        return jobStatusList;
    }

    public void setJobStatusList(List<Integer> jobStatusList) {
        this.jobStatusList = jobStatusList;
    }

    public String getCycSort() {
        return cycSort;
    }

    public void setCycSort(String cycSort) {
        this.cycSort = cycSort;
    }

    public String getExecTimeSort() {
        return execTimeSort;
    }

    public void setExecTimeSort(String execTimeSort) {
        this.execTimeSort = execTimeSort;
    }

    public String getExecStartSort() {
        return execStartSort;
    }

    public void setExecStartSort(String execStartSort) {
        this.execStartSort = execStartSort;
    }

    public String getExecEndSort() {
        return execEndSort;
    }

    public void setExecEndSort(String execEndSort) {
        this.execEndSort = execEndSort;
    }

    public String getRetryNumSort() {
        return retryNumSort;
    }

    public void setRetryNumSort(String retryNumSort) {
        this.retryNumSort = retryNumSort;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
