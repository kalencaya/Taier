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

package com.dtstack.taier.dao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resource {

    /**
     * @return the file name of the upload as provided in the form submission
     */
    private String fileName;

    private String uploadedFileName;

    /**
     * @return the size of the upload, in bytes
     */
    private int size;

    private String contentType;

    /**
     * file header key
     */
    private String key;

    public Resource() {
    }

    public Resource(String fileName, String uploadedFileName, int size, String contentType, String key) {
        this.uploadedFileName = uploadedFileName;
        this.fileName = fileName;
        this.size = size;
        this.contentType = contentType;
        this.key = key;
    }
}

