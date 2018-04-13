package pe.gob.sunat.servicio.registro.comppago.factura.gem.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-04-10T16:35:03.725-05:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "billService",
                  wsdlLocation = "file:/home/admin/git/openfact/src/main/resources/wsdl/guia_remision.wsdl",
                  targetNamespace = "http://service.gem.factura.comppago.registro.servicio.sunat.gob.pe/")
public class BillService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.gem.factura.comppago.registro.servicio.sunat.gob.pe/", "billService");
    public final static QName BillServicePort1 = new QName("http://service.gem.factura.comppago.registro.servicio.sunat.gob.pe/", "BillServicePort.1");
    public final static QName BillServicePort = new QName("http://service.gem.factura.comppago.registro.servicio.sunat.gob.pe/", "BillServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/admin/git/openfact/src/main/resources/wsdl/guia_remision.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(BillService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/admin/git/openfact/src/main/resources/wsdl/guia_remision.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BillService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BillService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BillService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BillService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BillService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BillService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns BillService
     */
    @WebEndpoint(name = "BillServicePort.1")
    public pe.gob.sunat.service.BillService getBillServicePort1() {
        return super.getPort(BillServicePort1, pe.gob.sunat.service.BillService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BillService
     */
    @WebEndpoint(name = "BillServicePort.1")
    public pe.gob.sunat.service.BillService getBillServicePort1(WebServiceFeature... features) {
        return super.getPort(BillServicePort1, pe.gob.sunat.service.BillService.class, features);
    }


    /**
     *
     * @return
     *     returns BillService
     */
    @WebEndpoint(name = "BillServicePort")
    public pe.gob.sunat.service.BillService getBillServicePort() {
        return super.getPort(BillServicePort, pe.gob.sunat.service.BillService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BillService
     */
    @WebEndpoint(name = "BillServicePort")
    public pe.gob.sunat.service.BillService getBillServicePort(WebServiceFeature... features) {
        return super.getPort(BillServicePort, pe.gob.sunat.service.BillService.class, features);
    }

}