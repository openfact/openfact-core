/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openfact.connections.infinispan;

import org.infinispan.Cache;
import org.openfact.provider.Provider;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public interface InfinispanConnectionProvider extends Provider {

    String ORGANIZATION_CACHE_NAME = "organizations";
    String ORGANIZATION_REVISIONS_CACHE_NAME = "organizationRevisions";
    int ORGANIZATION_REVISIONS_CACHE_DEFAULT_MAX = 10000;

    String USER_CACHE_NAME = "users";
    String USER_REVISIONS_CACHE_NAME = "userRevisions";
    int USER_REVISIONS_CACHE_DEFAULT_MAX = 100000;

    String SESSION_CACHE_NAME = "sessions";
    String OFFLINE_SESSION_CACHE_NAME = "offlineSessions";
    String LOGIN_FAILURE_CACHE_NAME = "loginFailures";
    String WORK_CACHE_NAME = "work";
    String AUTHORIZATION_CACHE_NAME = "authorization";

    <K, V> Cache<K, V> getCache(String name);

}