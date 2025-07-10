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

import com.dtstack.taier.common.exception.TaierDefineException;
import com.dtstack.taier.pluginapi.enums.EJobType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum EScheduleJobType {

    VIRTUAL(-1, "虚节点", -1, 0, null, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    SPARK_SQL(0, "SparkSQL", EJobType.SQL.getType(), 1, EComponentType.SPARK, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    SPARK(1, "Spark", EJobType.MR.getType(), 2, EComponentType.SPARK, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    SYNC(2, "数据同步", EJobType.SYNC.getType(), 3, EComponentType.FLINK, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    FLINK_SQL(5, "FlinkSQL", EJobType.SQL.getType(), 5, EComponentType.FLINK, EComputeType.STREAM, EJobClientType.WORKER_PLUGIN),
    DATA_ACQUISITION(6, "实时采集", EJobType.SYNC.getType(), 4, EComponentType.FLINK, EComputeType.STREAM, EJobClientType.WORKER_PLUGIN),
    HIVE_SQL(7, "HiveSQL", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    OCEANBASE_SQL(8, "OceanBaseSQL", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    WORK_FLOW(10, "工作流", -1, 9, null, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    FLINK_MR(11, "Flink", EJobType.MR.getType(), 11, EComponentType.FLINK, EComputeType.STREAM, EJobClientType.WORKER_PLUGIN),
    PYTHON(12, "Python", EJobType.PYTHON.getType(), 12, EComponentType.SCRIPT, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    SHELL(13, "Shell", EJobType.PYTHON.getType(), 13, EComponentType.SCRIPT, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    CLICK_HOUSE_SQL(14, "ClickHouseSQL", EJobType.SQL.getType(), 14, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    DORIS_SQL(15, "DorisSQL", EJobType.SQL.getType(), 15, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    SPARK_PYTHON(16, "PySpark", EJobType.PYTHON.getType(), 12, EComponentType.SPARK, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    MYSQL(17, "MySQL", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    GREENPLUM(18, "Greenplum", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    GAUSS_DB(19, "GaussDB", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    POSTGRESQL(20, "PostgreSQL", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    SQLSERVER(21, "SQLServer", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    TIDB(22, "TiDB", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    VERTICA(23, "Vertica", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    MAXCOMPUTE(24, "MaxCompute", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    HADOOP_MR(25, "HadoopMR", EJobType.MR.getType(), 16, EComponentType.HDFS, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    DATAX(26,"DataX", EJobType.PYTHON.getType(),14, EComponentType.DATAX, EComputeType.BATCH, EJobClientType.WORKER_PLUGIN),
    ORACLE_SQL(27, "OracleSQL", EJobType.SQL.getType(), 4, null, EComputeType.BATCH, EJobClientType.DATASOURCE_PLUGIN),
    ;

    private final Integer type;
    private final String name;

    /**
     * 引擎能够接受的jobType
     * SQL              0
     * MR               1
     * SYNC             2
     * PYTHON           3
     * 不接受的任务类型    -1
     */
    private final Integer engineJobType;
    private final Integer sort;
    private final EComponentType componentType;

    /**
     * 任务所属类型
     */
    private final EComputeType computeType;

    /**
     * job client 类型 {@link EJobClientType}
     */
    private final EJobClientType jobClientType;

    public static final List<Integer> STREAM_JOB_TYPES = new ArrayList<>();
    public static final List<Integer> BATCH_JOB_TYPES = new ArrayList<>();

    static {
        for (EScheduleJobType value : EScheduleJobType.values()) {
            if (EComputeType.STREAM == value.getComputeType()) {
                STREAM_JOB_TYPES.add(value.getValue());
            }
            if (EComputeType.BATCH == value.getComputeType()) {
                BATCH_JOB_TYPES.add(value.getValue());
            }
        }
    }

    public static EScheduleJobType getByTaskType(int type) {
        EScheduleJobType[] eJobTypes = EScheduleJobType.values();
        for (EScheduleJobType eJobType : eJobTypes) {
            if (eJobType.type == type) {
                return eJobType;
            }
        }
        throw new TaierDefineException("不支持的任务类型");
    }

    public Integer getValue() {
        return type;
    }

    public Integer getVal() {
        return type;
    }
}
