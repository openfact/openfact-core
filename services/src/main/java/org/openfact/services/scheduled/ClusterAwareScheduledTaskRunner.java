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
import org.openfact.cluster.ClusterProvider;
import org.openfact.cluster.ExecutionResult;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.timer.ScheduledTask;

import java.util.concurrent.Callable;

/**
 * Ensures that there are not concurrent executions of same task (either on this host or any other cluster host)
 *
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class ClusterAwareScheduledTaskRunner extends ScheduledTaskRunner {

    private static final Logger logger = Logger.getLogger(ClusterAwareScheduledTaskRunner.class);

    private final int intervalSecs;

    public ClusterAwareScheduledTaskRunner(OpenfactSessionFactory sessionFactory, ScheduledTask task, long intervalMillis) {
        super(sessionFactory, task);
        this.intervalSecs = (int) (intervalMillis / 1000);
    }

    @Override
    protected void runTask(final OpenfactSession session) {
        session.getTransactionManager().begin();

        ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
        String taskKey = task.getClass().getSimpleName();

        ExecutionResult<Void> result = clusterProvider.executeIfNotExecuted(taskKey, intervalSecs, new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                task.run(session);
                return null;
            }

        });

        session.getTransactionManager().commit();

        if (result.isExecuted()) {
            logger.debugf("Executed scheduled task %s", taskKey);
        } else {
            logger.debugf("Skipped execution of task %s as other cluster node is executing it", taskKey);
        }
    }


}
