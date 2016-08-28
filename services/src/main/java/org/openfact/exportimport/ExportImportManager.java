package org.openfact.exportimport;

import java.io.IOException;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.services.ServicesLogger;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public class ExportImportManager {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    private OpenfactSessionFactory sessionFactory;

    private final String organizationName;

    private ExportProvider exportProvider;
    private ImportProvider importProvider;

    public ExportImportManager(OpenfactSession session) {
        this.sessionFactory = session.getOpenfactSessionFactory();

        organizationName = ExportImportConfig.getOrganizationName();

        String providerId = ExportImportConfig.getProvider();
        String exportImportAction = ExportImportConfig.getAction();

        if (ExportImportConfig.ACTION_EXPORT.equals(exportImportAction)) {
            exportProvider = session.getProvider(ExportProvider.class, providerId);
            if (exportProvider == null) {
                throw new RuntimeException("Export provider '" + providerId + "' not found");
            }
        } else if (ExportImportConfig.ACTION_IMPORT.equals(exportImportAction)) {
            importProvider = session.getProvider(ImportProvider.class, providerId);
            if (importProvider == null) {
                throw new RuntimeException("Import provider '" + providerId + "' not found");
            }
        }
    }

    public boolean isRunImport() {
        return importProvider != null;
    }

    public boolean isImportMasterIncluded() {
        if (!isRunImport()) {
            throw new IllegalStateException("Import not enabled");
        }
        try {
            return importProvider.isMasterOrganizationExported();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isRunExport() {
        return exportProvider != null;
    }

    public void runImport() {
        try {
            Strategy strategy = ExportImportConfig.getStrategy();
            if (organizationName == null) {
                logger.fullModelImport(strategy.toString());
                importProvider.importModel(sessionFactory, strategy);
            } else {
                logger.organizationImportRequested(organizationName, strategy.toString());
                importProvider.importOrganization(sessionFactory, organizationName, strategy);
            }
            logger.importSuccess();
        } catch (IOException e) {
            throw new RuntimeException("Failed to run import", e);
        }
    }

    public void runExport() {
        try {
            if (organizationName == null) {
                logger.fullModelExportRequested();
                exportProvider.exportModel(sessionFactory);
            } else {
                logger.organizationExportRequested(organizationName);
                exportProvider.exportOrganization(sessionFactory, organizationName);
            }
            logger.exportSuccess();
        } catch (IOException e) {
            throw new RuntimeException("Failed to run export");
        }
    }

}
