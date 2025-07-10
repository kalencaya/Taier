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

import com.baomidou.mybatisplus.annotation.TableName;
import com.dtstack.taier.common.enums.TempJobType;
import com.google.common.base.Charsets;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Getter
@Setter
@TableName("develop_select_sql")
public class DevelopSelectSql extends TenantEntity {

    /**
     * 实例id
     */
    private String jobId;

    /**
     * 临时表名称（临时表用于存放查询的结果）
     */
    private String tempTableName;

    /**
     * SQL语法的类型
     */
    private int isSelectSql;

    /**
     * 任务的SQL
     */
    private String sqlText;

    /**
     * 字段信息
     */
    private String parsedColumns;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 引擎类型
     */
    private int taskType;

    /**
     * 数据源id
     */
    private Long datasourceId;

    /**
     * 如果是数据同步任务则需要解密
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getCorrectSqlText() throws UnsupportedEncodingException {
        String sql;
        if (isSelectSql == TempJobType.SYNC_TASK.getType()) {
            sql = URLDecoder.decode(getSqlText(), Charsets.UTF_8.name());
        } else {
            sql = getSqlText();
        }
        return sql;
    }
}
