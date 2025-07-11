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

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("datasource_info")
public class DsInfo extends TenantModel {

    /**
     * 数据源类型唯一
     */
    @TableField("data_type")
    private String dataType;

    /**
     * 数据源类型编码
     */
    @TableField("data_type_code")
    private Integer dataTypeCode;

    /**
     * 数据源版本
     */
    @TableField("data_version")
    private String dataVersion;

    /**
     * 数据源名称
     */
    @TableField("data_name")
    private String dataName;

    /**
     * 数据源描述
     */
    @TableField("data_desc")
    private String dataDesc;

    /**
     * 数据源连接信息
     */
    @TableField("link_json")
    private String linkJson;

    /**
     * 数据源填写的表单信息
     */
    @TableField("data_json")
    private String dataJson;

    /**
     * 连接状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否有meta标志
     */
    @TableField("is_meta")
    private Integer isMeta;

    /**
     * 数据库名称
     */
    @TableField("schema_name")
    private String schemaName;
}