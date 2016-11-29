/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
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
 *******************************************************************************/

package org.openfact.common.util.reflections;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;

/**
 * A {@link PrivilegedAction} that calls {@link AccessibleObject#setAccessible(boolean)}
 */
public class SetAccessiblePrivilegedAction implements PrivilegedAction<Void> {

    private final AccessibleObject member;

    public SetAccessiblePrivilegedAction(AccessibleObject member) {
        this.member = member;
    }

    public Void run() {
        member.setAccessible(true);
        return null;
    }

}
