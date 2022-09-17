package org.acme.rest;

import java.util.Set;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.acme.dto.ClienteDto;
import org.acme.dto.ResponseError;
import org.acme.service.ClienteService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cliente")
public class ClienteRest {

    @Inject
    ClienteService service;
    @Inject
    Validator validator;

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deleta um cliente", 
    description = "Deleta um cliente")
    @APIResponse(responseCode = "204",
    description =  "Deletar um cliente",
    content = @Content(mediaType = "application/json",    
    schema = @Schema(implementation = ClienteDto.class)))
    
    public Response deletar(@PathParam("id") Long id) {

        if (id != null) {
            service.deletar(id);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Atualizar um cliente", 
    description = "Atualiza um cliente")
    @APIResponse(responseCode = "204",
    description =  "Cliente atualizado com sucesso",
    content = @Content(mediaType = "application/json",    
    schema = @Schema(implementation = ClienteDto.class)))

    public Response atualizar(@PathParam("id") Long id, ClienteDto dto) {
        Set<ConstraintViolation<ClienteDto>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {            
            ResponseError responseError = ResponseError.createFromValidation(violations);
            return Response.status(Response.Status.BAD_REQUEST).entity(responseError).build();
        }
        service.atualizar(dto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("")
    @Operation(summary = "Listar todos os clientes", 
    description = "Retorna uma lista de clientes")
    @APIResponse(responseCode = "200",
    description =  "lista de clientes",
    content = @Content(mediaType = "application/json",    
    schema = @Schema(implementation = ClienteDto.class)))

    public Response listar() {
        return Response.status(Response.Status.OK).entity(service.listar()).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Consultar cliente por ID", 
    description = "Retorna um cliente")
    @APIResponse(responseCode = "200",
    description =  "Lista um cliente",
    content = @Content(mediaType = "application/json",    
    schema = @Schema(implementation = ClienteDto.class)))
    public Response consultarPorId(Long id) {
        return Response.status(Response.Status.OK).entity(service.consultarPorId(id)).build();
    }

    @POST
    @Path("")
    @Transactional
    @Operation(summary = "Cadastrar um cliente", 
    description = "Retorna uma lista de clientes")
    @APIResponse(responseCode = "201",
    description =  "Cadastrar um cliente",
    content = @Content(mediaType = "application/json",    
    schema = @Schema(implementation = ClienteDto.class)))
    
    public Response inserir(ClienteDto dto) {
        Set<ConstraintViolation<ClienteDto>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {
             ResponseError responseError = ResponseError.createFromValidation(violations);
             return Response.status(Response.Status.BAD_REQUEST).entity(responseError).build();
        }
        service.inserir(dto);
        return Response.status(Response.Status.CREATED.getStatusCode()).entity(dto).build();

    }

}
