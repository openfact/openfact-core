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

package org.openfact.exportimport.util;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionTask;

import java.io.IOException;

/**
 * Just to wrap {@link IOException}
 *
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public abstract class ExportImportSessionTask implements OpenfactSessionTask {

    @Override
    public void run(OpenfactSession session) {
        try {
            runExportImportTask(session);
        } catch (IOException ioe) {
            throw new RuntimeException("Error during export/import: " + ioe.getMessage(), ioe);
        }
    }

    protected abstract void runExportImportTask(OpenfactSession session) throws IOException;
}
