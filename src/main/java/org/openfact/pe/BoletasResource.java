package org.openfact.pe;

import org.openfact.pe.representations.idm.BoletaRepresentation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/organizations/{organizationId}/pe/documentos/boletas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BoletasResource {

    @GET
    @Path("/")
    List<BoletaRepresentation> getBoletas(
            @PathParam("organizationId") String organizationId,
            @QueryParam("estado") @DefaultValue("ABIERTO") String estado,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

    @POST
    @Path("/")
    BoletaRepresentation crearBoleta(
            @PathParam("organizationId") String organizationId,
            @Valid BoletaRepresentation rep
    );


    @GET
    @Path("/{documentId}")
    BoletaRepresentation getBoleta(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

    @PUT
    @Path("/{documentId}")
    void actualizarBoleta(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento,
            @Valid BoletaRepresentation rep
    );

    @DELETE
    @Path("/{documentId}")
    void eliminarBoleta(
            @PathParam("organizationId") String organizationId,
            @PathParam("documentId") String idDocumento
    );

}
