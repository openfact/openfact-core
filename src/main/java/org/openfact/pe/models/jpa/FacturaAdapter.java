package org.openfact.pe.models.jpa;

import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.FacturaDetalleEntity;
import org.openfact.pe.models.jpa.entities.FacturaEntity;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FacturaAdapter implements FacturaModel {

    private final EntityManager em;
    private final FacturaEntity factura;

    public FacturaAdapter(EntityManager em, FacturaEntity factura) {
        this.em = em;
        this.factura = factura;
    }

    @Override
    public String getId() {
        return factura.getId();
    }

    @Override
    public String getSerie() {
        return factura.getSerie();
    }

    @Override
    public Integer getNumero() {
        return factura.getNumero();
    }

    @Override
    public boolean getEnviarSUNAT() {
        return factura.isEnviarSUNAT();
    }

    @Override
    public void setEnviarSUNAT(boolean enviarSUNAT) {
        factura.setEnviarSUNAT(enviarSUNAT);
    }

    @Override
    public boolean getEnviarCliente() {
        return factura.isEnviarCliente();
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        factura.setEnviarCliente(enviarCliente);
    }

    @Override
    public String getObservaciones() {
        return factura.getObservaciones();
    }

    @Override
    public void setObservaciones(String observaciones) {
        factura.setObservaciones(observaciones);
    }

    @Override
    public EstadoComprobantePago getEstado() {
        return factura.getEstado();
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        factura.setEstado(estado);
    }

    @Override
    public String getError() {
        return factura.getErrorDescription();
    }

    @Override
    public void setError(String error) {
        factura.setErrorDescription(error);
    }

    @Override
    public String getFileId() {
        return factura.getFileId();
    }

    @Override
    public void setFileId(String fileId) {
        factura.setFileId(fileId);
    }

    @Override
    public String getCdrFileId() {
        return factura.getCdrFileId();
    }

    @Override
    public void setCdrFileId(String fileId) {
        factura.setCdrFileId(fileId);
    }

    @Override
    public FechaModel getFecha() {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyFechaAdapter(factura.getFecha());
        } else {
            return new FechaAdapter(factura.getFecha());
        }
    }

    @Override
    public ClienteModel getCliente() {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyClienteAdapter(factura.getCliente());
        } else {
            return new ClienteAdapter(factura.getCliente());
        }
    }

    @Override
    public ImpuestosModel getImpuestos() {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyImpuestosAdapter(factura.getImpuestos());
        } else {
            return new ImpuestosAdapter(factura.getImpuestos());
        }
    }

    @Override
    public MonedaModel getMoneda() {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyMonedaAdapter(factura.getMoneda());
        } else {
            return new MonedaAdapter(factura.getMoneda());
        }
    }

    @Override
    public TotalModel getTotal() {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyTotalAdapter(factura.getTotal());
        } else {
            return new TotalAdapter(factura.getTotal());
        }
    }

    @Override
    public TotalInformacionAdicionalModel getTotalInformacionAdicional() {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyTotalInformacionAdicionalAdapter(factura.getTotalInformacionAdicional());
        } else {
            return new TotalInformacionAdicionalAdapter(factura.getTotalInformacionAdicional());
        }
    }

    @Override
    public List<DetalleComprobantePagoModel> getDetalle() {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return factura.getDetalle()
                    .stream()
                    .map(ReadOnlyDetalleComprobantePagoAdapter::new)
                    .collect(Collectors.toList());
        } else {
            return factura.getDetalle()
                    .stream()
                    .map(DetalleComprobantePagoAdapter::new)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<DetalleComprobantePagoModel> setDetalle(List<DetalleComprobantePagoBean> beans) {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            ReadOnlyUtils.throwException();
        }

        List<DetalleComprobantePagoModel> result = new ArrayList<>();

        em.createNamedQuery("deleteFacturaDetalle").setParameter("idFactura", factura.getId()).executeUpdate();
        factura.setDetalle(new ArrayList<>());

        for (DetalleComprobantePagoBean bean : beans) {
            FacturaDetalleEntity detalleEntity = new FacturaDetalleEntity();

            detalleEntity.setId(ModelUtils.generateId());
            detalleEntity.setFactura(factura);

            detalleEntity.setUnidadMedida(bean.getUnidadMedida());
            detalleEntity.setDescripcion(bean.getDescripcion());
            detalleEntity.setTipoIGV(bean.getTipoIGV());
            detalleEntity.setCantidad(bean.getCantidad());
            detalleEntity.setValorUnitario(bean.getValorUnitario());
            detalleEntity.setPrecioUnitario(bean.getPrecioUnitario());
            detalleEntity.setSubtotal(bean.getSubtotal());
            detalleEntity.setTotal(bean.getTotal());
            detalleEntity.setTotalIGV(bean.getTotalIGV());
            detalleEntity.setTotalISC(bean.getTotalISC());

            em.persist(detalleEntity);
            factura.getDetalle().add(detalleEntity);

            result.add(new DetalleComprobantePagoAdapter(detalleEntity));
        }

        return result;
    }

}
