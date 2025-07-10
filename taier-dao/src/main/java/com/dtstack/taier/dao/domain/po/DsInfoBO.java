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

package com.dtstack.taier.dao.domain.po;

import com.alibaba.fastjson.JSONObject;
import com.dtstack.taier.common.constant.FormNames;
import com.dtstack.taier.common.util.DataSourceUtils;
import com.dtstack.taier.dao.domain.DsInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.Map;

@Slf4j
@Getter
@Setter
public class DsInfoBO {

    private Long id;

    /**
     * 数据源类型唯一
     */

    private String dataType;

    /**
     * 数据源类型编码
     */
    private Integer dataTypeCode;

    /**
     * 数据源版本
     */
    private String dataVersion;

    /**
     * 数据源名称
     */
    private String dataName;

    private Long tenantId;

    /**
     * 数据源填写的表单信息
     */
    private String dataJson;

    private JSONObject data;

    /**
     * 连接状态
     */
    private Integer status;

    /**
     * 是否有meta标志
     */
    private Integer isMeta;

    /**
     * 数据库名称
     */
    private String schemaName;

    private String defaultFs;

    private Map<String, Object> hadoopConfig;

    private Map<String, Object> kerberosConfig;

    private String userName;

    private String password;

    private String jdbc;

    public static DsInfoBO buildDsInfoBO(DsInfo dsInfo) {
        DsInfoBO bo = new DsInfoBO();
        BeanUtils.copyProperties(dsInfo, bo);
        try {
            JSONObject data = DataSourceUtils.getDataSourceJson(dsInfo.getDataJson());
            bo.setData(data);
            JSONObject hadoopConfig = data.getJSONObject(FormNames.HADOOP_CONFIG);
            hadoopConfig = hadoopConfig == null ? new JSONObject(1) : hadoopConfig;
            String defaultFs = String.valueOf(data.getOrDefault(FormNames.DEFAULT_FS, ""));
            bo.setHadoopConfig(hadoopConfig.fluentPut(FormNames.DEFAULT_FS, defaultFs));
            bo.setKerberosConfig(data.getJSONObject(FormNames.KERBEROS_CONFIG));
            bo.setDefaultFs(defaultFs);
            bo.setUserName(String.valueOf(data.getOrDefault(FormNames.USERNAME, "")));
            bo.setPassword(String.valueOf(data.getOrDefault(FormNames.PASSWORD, "")));
            bo.setJdbc(String.valueOf(data.getOrDefault(FormNames.JDBC_URL, "")));
        } catch (Exception e) {
            log.error("build datasource info", e);
            throw e;
        }
        return bo;
    }
}
