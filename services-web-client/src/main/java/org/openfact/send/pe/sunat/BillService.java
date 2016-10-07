
package org.openfact.send.pe.sunat;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "billService", targetNamespace = "http://service.sunat.gob.pe")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BillService {


    /**
     * 
     * @param ticket
     * @return
     *     returns org.openfact.ubl.pe.send.StatusResponse
     */
    @WebMethod(action = "urn:getStatus")
    @WebResult(name = "status", targetNamespace = "")
    @RequestWrapper(localName = "getStatus", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.GetStatus")
    @ResponseWrapper(localName = "getStatusResponse", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.GetStatusResponse")
    public StatusResponse getStatus(
        @WebParam(name = "ticket", targetNamespace = "")
        String ticket);

    /**
     * 
     * @param fileName
     * @param contentFile
     * @return
     *     returns byte[]
     */
    @WebMethod(action = "urn:sendBill")
    @WebResult(name = "applicationResponse", targetNamespace = "")
    @RequestWrapper(localName = "sendBill", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.SendBill")
    @ResponseWrapper(localName = "sendBillResponse", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.SendBillResponse")
    public byte[] sendBill(
        @WebParam(name = "fileName", targetNamespace = "")
        String fileName,
        @WebParam(name = "contentFile", targetNamespace = "")
        DataHandler contentFile);

    /**
     * 
     * @param fileName
     * @param contentFile
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:sendPack")
    @WebResult(name = "ticket", targetNamespace = "")
    @RequestWrapper(localName = "sendPack", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.SendPack")
    @ResponseWrapper(localName = "sendPackResponse", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.SendPackResponse")
    public String sendPack(
        @WebParam(name = "fileName", targetNamespace = "")
        String fileName,
        @WebParam(name = "contentFile", targetNamespace = "")
        DataHandler contentFile);

    /**
     * 
     * @param fileName
     * @param contentFile
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:sendSummary")
    @WebResult(name = "ticket", targetNamespace = "")
    @RequestWrapper(localName = "sendSummary", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.SendSummary")
    @ResponseWrapper(localName = "sendSummaryResponse", targetNamespace = "http://service.sunat.gob.pe", className = "org.openfact.ubl.send.pe.sunat.SendSummaryResponse")
    public String sendSummary(
        @WebParam(name = "fileName", targetNamespace = "")
        String fileName,
        @WebParam(name = "contentFile", targetNamespace = "")
        DataHandler contentFile);

}
