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

package com.dtstack.taier.common.enums;

import com.dtstack.taier.common.exception.DtCenterDefException;
import com.dtstack.taier.datasource.api.source.DataSourceType;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum ETableType {

    HIVE(1, "Hive", DataSourceType.HIVE),
    LIBRA(2, "LibrA", DataSourceType.LIBRA),
    TIDB(3, "TiDB", DataSourceType.TiDB),
    ORACLE(4, "Oracle", DataSourceType.Oracle),
    GREENPLUM(5, "GreenPlum", DataSourceType.GREENPLUM6),
    IMPALA(6, "IMPALA", DataSourceType.IMPALA),
    ADB_FOR_PG(7, "AnalyticDB for PostgreSQL", DataSourceType.ADB_FOR_PG);

    private final int type;
    private final String content;
    private final DataSourceType dataSourceType;

    final static Set<Integer> dataSourceTypeToHiveSet = Sets.newHashSet(
            DataSourceType.SparkThrift2_1.getVal(),
            DataSourceType.Spark.getVal(),
            DataSourceType.HIVE1X.getVal(),
            DataSourceType.HIVE.getVal(),
            DataSourceType.HIVE3X.getVal(),
            DataSourceType.IMPALA.getVal());

    public static ETableType getTableType(int tableType) {
        for (ETableType eType : ETableType.values()) {
            if (eType.getType() == tableType) {
                return eType;
            }
        }

        throw new DtCenterDefException(String.format("not support tableType's ETableType:%d", tableType));
    }

    public static ETableType getDatasourceType(Integer datasourceType) {
        if (dataSourceTypeToHiveSet.contains(datasourceType)) {
            return ETableType.HIVE;
        }
        for (ETableType etype : ETableType.values()) {
            if (etype.getDataSourceType().getVal().equals(datasourceType)) {
                return etype;
            }
        }
        throw new DtCenterDefException(String.format("not support datasourceType's ETableType : %d", datasourceType));
    }
}
