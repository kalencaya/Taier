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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("console_kerberos")
public class KerberosConfig extends BaseEntity {

    private Long clusterId;

    private String name;

    private Integer openKerberos;

    private String remotePath;

    private String principal;

    private String principals;

    private Integer componentType;

    /**
     * krb5 的文件名称
     */
    private String krbName;

    private String mergeKrbContent;
    /**
     * 因为kerberos文件可能在组件保存之前上传,因此只能添加版本来区分
     */
    private String componentVersion;
}
