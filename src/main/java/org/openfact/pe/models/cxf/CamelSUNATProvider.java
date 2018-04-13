package org.openfact.pe.models.cxf;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.openfact.pe.models.SUNATProvider;
import pe.gob.sunat.service.StatusResponse;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mail.util.ByteArrayDataSource;

@ApplicationScoped
public class CamelSUNATProvider implements SUNATProvider {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelContext;

    @Override
    public byte[] sendBill(String fileName, byte[] file) {
        DataSource dataSource = new ByteArrayDataSource(file, "application/xml");
        DataHandler dataHandler = new DataHandler(dataSource);

        ProducerTemplate producer = camelContext.createProducerTemplate();
        Object[] serviceParams = new Object[] {fileName, dataHandler, "Carlos"};
        Object result = producer.requestBody("direct:start", serviceParams);
        System.out.println(result);
        return new byte[0];
    }

    @Override
    public StatusResponse getStatus(String ticket) {
        return null;
    }

    @Override
    public String sendSummary(String fileName, byte[] file) {
        return null;
    }

    @Override
    public String sendPack(String fileName, byte[] file) {
        return null;
    }

}