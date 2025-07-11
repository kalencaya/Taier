/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.taier.dao.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.dtstack.taier.common.constant.MP;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel<T extends Model<?>> extends Model<T> implements ID<Long> {

    @TableId(value = MP.COLUMN_ID, type = IdType.AUTO)
    private Long id;

    @TableField(value = MP.COLUMN_CREATE_BY, fill = FieldFill.INSERT)
    private Long createUserId;

    @TableField(value = MP.COLUMN_UPDATE_BY, fill = FieldFill.UPDATE)
    private Long modifyUserId;

    @TableLogic(value = "0", delval = "1")
    @TableField(MP.COLUMN_DELETED)
    private boolean isDeleted;

    @TableField(value = MP.COLUMN_CREATE_AT, fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(value = MP.COLUMN_UPDATE_AT, fill = FieldFill.UPDATE)
    private Date gmtModified;

}
