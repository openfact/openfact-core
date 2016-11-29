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
package org.openfact.connections.jpa;

import org.openfact.models.OpenfactSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 * @version $Revision: 1 $
 */
public class JndiEntityManagerLookup {
    public static EntityManager getSessionEntityManager(OpenfactSession session, String entityManagerFactoryJndiName) {
        EntityManagerFactory factory = null;
        try {
            factory = (EntityManagerFactory) new InitialContext().lookup(entityManagerFactoryJndiName);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        EntityManager em = factory.createEntityManager();
        session.getTransactionManager().enlist(new JpaOpenfactTransaction(em));
        return em;
    }
}
