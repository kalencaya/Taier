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

import com.dtstack.taier.dao.domain.ScheduleTaskShade;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class ScheduleTaskShadeDTO extends ScheduleTaskShade {

    private Timestamp startGmtModified;
    private Timestamp endGmtModified;

    private List<Integer> periodTypeList;
    private List<Integer> taskTypeList;
    private String fuzzName;
    private Integer searchType;

    private Timestamp startTime;

    private Timestamp endTime;

    private String taskName;

    private Integer pageSize = 10;

    private Integer pageIndex = 1;

    private String sort = "desc";

    private Integer version;

}
