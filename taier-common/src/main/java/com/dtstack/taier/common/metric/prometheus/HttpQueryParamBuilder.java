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

package com.dtstack.taier.common.metric.prometheus;

import com.dtstack.taier.common.metric.QueryInfo;

import java.io.UnsupportedEncodingException;

public class HttpQueryParamBuilder extends AbsHttpQueryParamBuilder {

    private static final String QUERY_RANGE_TPL = "query=${query}&time=${time}";

    public static String builder(String metricName, Long time, QueryInfo queryInfo) throws UnsupportedEncodingException {

        String reqParam = "";
        if (time != null && time > 0) {
            long timeSec = time / 1000;
            reqParam = QUERY_RANGE_TPL.replace("${time}", timeSec + "");
        } else {
            reqParam = QUERY_RANGE_TPL.replace("&time=${time}", "");
        }

        String queryParam = buildQuery(metricName, queryInfo);

        return reqParam.replace("${query}", queryParam);
    }
}
