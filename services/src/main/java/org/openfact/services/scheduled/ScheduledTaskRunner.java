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

package org.openfact.services.scheduled;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.services.ServicesLogger;
import org.openfact.timer.ScheduledTask;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class ScheduledTaskRunner implements Runnable {

    private static final Logger logger = Logger.getLogger(ScheduledTaskRunner.class);

    protected final OpenfactSessionFactory sessionFactory;
    protected final ScheduledTask task;

    public ScheduledTaskRunner(OpenfactSessionFactory sessionFactory, ScheduledTask task) {
        this.sessionFactory = sessionFactory;
        this.task = task;
    }

    @Override
    public void run() {
        OpenfactSession session = sessionFactory.create();
        try {
            runTask(session);
        } catch (Throwable t) {
            ServicesLogger.LOGGER.failedToRunScheduledTask(t, task.getClass().getSimpleName());

            session.getTransactionManager().rollback();
        } finally {
            try {
                session.close();
            } catch (Throwable t) {
                ServicesLogger.LOGGER.failedToCloseProviderSession(t);
            }
        }
    }

    protected void runTask(OpenfactSession session) {
        session.getTransactionManager().begin();
        task.run(session);
        session.getTransactionManager().commit();

        logger.debug("Executed scheduled task " + task.getClass().getSimpleName());
    }

}
