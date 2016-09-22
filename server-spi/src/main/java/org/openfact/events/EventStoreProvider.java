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

package org.openfact.events;

import org.openfact.events.admin.AdminEventQuery;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public interface EventStoreProvider extends EventListenerProvider {

    public EventQuery createQuery();

    public AdminEventQuery createAdminQuery();

    public void clear();

    public void clear(String organizationId);

    public void clear(String organizationId, long olderThan);

    public void clearAdmin();

    public void clearAdmin(String organizationId);

    public void clearAdmin(String organizationId, long olderThan);

}
