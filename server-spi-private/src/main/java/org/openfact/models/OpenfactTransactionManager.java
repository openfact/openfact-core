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

package org.openfact.models;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 * @version $Revision: 1 $
 */
public interface OpenfactTransactionManager extends OpenfactTransaction {

    JTAPolicy getJTAPolicy();

    void setJTAPolicy(JTAPolicy policy);

    void enlist(OpenfactTransaction transaction);

    void enlistAfterCompletion(OpenfactTransaction transaction);

    void enlistPrepare(OpenfactTransaction transaction);

    enum JTAPolicy {
        /**
         * Do not interact with JTA at all
         */
        NOT_SUPPORTED,
        /**
         * A new JTA Transaction will be created when Openfact TM begin() is called.  If an existing JTA transaction
         * exists, it is suspended and resumed after the Openfact transaction finishes.
         */
        REQUIRES_NEW,
    }
}