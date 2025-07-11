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

package com.dtstack.taier.common.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DataSourceParam implements Serializable {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(hidden = true)
    private Long userId;

    @ApiModelProperty(hidden = true)
    private Long tenantId;

    @ApiModelProperty(hidden = true)
    private Boolean isRoot;

    @ApiModelProperty(hidden = true)
    private Boolean isAdmin;

    @ApiModelProperty(hidden = true)
    private Long createUserId;

    @ApiModelProperty(hidden = true)
    private Long modifyUserId;

    @ApiModelProperty(hidden = true)
    private Boolean isOwner;

    /**
     * 是否删除
     */
    @ApiModelProperty(hidden = true)
    private Integer isDeleted = 0;

    @ApiModelProperty(hidden = true)
    private String dtToken;

    @ApiModelProperty(hidden = true)
    private String productCode;
}
