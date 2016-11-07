/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.utils;

public class MediaType {

    public static final String TEXT_HTML_UTF_8 = "text/html; charset=utf-8";
    public static final javax.ws.rs.core.MediaType TEXT_HTML_UTF_8_TYPE = new javax.ws.rs.core.MediaType("text", "html");

    public static final String APPLICATION_JSON = javax.ws.rs.core.MediaType.APPLICATION_JSON;
    public static final javax.ws.rs.core.MediaType APPLICATION_JSON_TYPE = javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

    public static final String APPLICATION_FORM_URLENCODED = javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
    public static final javax.ws.rs.core.MediaType APPLICATION_FORM_URLENCODED_TYPE = javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED_TYPE;

}
