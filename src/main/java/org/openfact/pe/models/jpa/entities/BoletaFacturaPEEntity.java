package org.openfact.pe.models.jpa.entities;

import org.openfact.core.models.jpa.entities.OrganizacionEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "boleta_factura_pe")
@NamedQueries(value = {

})
public class BoletaFacturaPEEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "id_asignado")
    private String idAsignado;

    @Embedded
    private ClientePEEntity cliente;

    @OneToOne
    @MapsId
    private OrganizacionEntity organizacion;

    @Version
    @Column(name = "version")
    private int version;

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoletaFacturaPEEntity)) {
            return false;
        }
        BoletaFacturaPEEntity other = (BoletaFacturaPEEntity) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAsignado() {
        return idAsignado;
    }

    public void setIdAsignado(String idAsignado) {
        this.idAsignado = idAsignado;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public OrganizacionEntity getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionEntity organizacion) {
        this.organizacion = organizacion;
    }

    public ClientePEEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientePEEntity cliente) {
        this.cliente = cliente;
    }
}
