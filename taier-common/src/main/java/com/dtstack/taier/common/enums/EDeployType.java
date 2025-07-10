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

import com.dtstack.taier.pluginapi.enums.EDeployMode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum EDeployType {

    STANDALONE(0, "standalone"),
    YARN(1, "yarn"),
    KUBERNETES(2, "kubernetes");

    private final Integer type;
    private final String name;

    public static EDeployType getDeployType(Integer type) {
        for (EDeployType eType : EDeployType.values()) {
            if (eType.getType().equals(type)) {
                return eType;
            }
        }
        return null;
    }

    public static EDeployType convertToDeployType(Integer mode) {
        if (null == mode) {
            return EDeployType.YARN;
        }
        EDeployMode deployMode = EDeployMode.getByType(mode);
        switch (deployMode) {
            case STANDALONE:
                return EDeployType.STANDALONE;
            default:
                return EDeployType.YARN;
        }
    }
}
