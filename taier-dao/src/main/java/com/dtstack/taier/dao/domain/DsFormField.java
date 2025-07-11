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
@TableName("datasource_form_field")
public class DsFormField extends BaseModel<DsFormField> {

    /**
     * 表单属性名称
     */
    @TableField("name")
    private String name;

    /**
     * 属性前label名称
     */
    @TableField("label")
    private String label;

    /**
     * 属性格式
     */
    @TableField("widget")
    private String widget;

    /**
     * 是否必填
     */
    @TableField("required")
    private Integer required;

    /**
     * 是否为隐藏
     */
    @TableField("invisible")
    private Integer invisible;

    /**
     * 表单属性中默认值
     */
    @TableField("default_value")
    private String defaultValue;

    /**
     * 输入框placeHold, 默认为空'
     */
    @TableField("place_hold")
    private String placeHold;

    /**
     * 请求数据Api接口地址，一般用于关联下拉框类型，如果不需要请求则为空
     */
    @TableField("request_api")
    private String requestApi;

    /**
     * 是否为数据源需要展示的连接信息字段。0-否; 1-是
     */
    @TableField("is_link")
    private Integer isLink;

    /**
     * 校验返回信息文案
     */
    @TableField("valid_info")
    private String validInfo;

    /**
     * 输入框后问号的提示信息
     */
    @TableField("tooltip")
    private String tooltip;

    /**
     * 前端表单属性style参数
     */
    @TableField("style")
    private String style;

    /**
     * 正则校验表达式
     */
    @TableField("regex")
    private String regex;

    /**
     * 对应数据源版本信息
     */
    @TableField("type_version")
    private String typeVersion;

    /**
     * select组件的下拉内容
     */
    @TableField("options")
    private String options;
}
