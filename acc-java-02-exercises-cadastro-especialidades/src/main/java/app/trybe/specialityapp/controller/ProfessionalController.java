package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.commons.BadRequestCreate;
import app.trybe.specialityapp.commons.DeleteNotFound;
import app.trybe.specialityapp.commons.EditNotFound;
import app.trybe.specialityapp.commons.RegistryNotFound;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Path("/professional")
public class ProfessionalController {

  @Autowired
  ProfessionalService service;

  /**
   * requisição get.
   */
  @GET
  @Path("/all")
  @Produces("application/json")
  public Response findAll() {
    try {
      List<Professional> registro = service.getAllProf();

      return Response.status(200).entity(registro).build();
    } catch (RegistryNotFound error) {
      return Response.status(Response.Status.NOT_FOUND)
          .entity(new ApplicationError(error.getMessage(), Response.Status.NOT_FOUND)).build();
    }

  }

  /**
   * requisição post.
   */
  @POST
  @Path("/add")
  @Consumes("application/json")
  @Produces("application/json")
  public Response insert(Professional p) {
    try {
      service.createNew(p);

      return Response.status(201).entity("Inserido").build();
    } catch (BadRequestCreate error) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity(new ApplicationError(error.getMessage(), Response.Status.BAD_REQUEST)).build();
    }

  }

  /**
   * requisição put.
   */
  @PUT
  @Path("/edit/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response edit(@PathParam("id") Integer id, Professional p) {
    try {
      service.updateById(id, p);

      return Response.status(200).entity(String.format("ID [%d] atualizado", id)).build();
    } catch (EditNotFound error) {
      return Response.status(Response.Status.NOT_FOUND)
          .entity(new ApplicationError(error.getMessage(), Response.Status.NOT_FOUND)).build();
    }

  }

  /**
   * requisição delete.
   */
  @DELETE
  @Path("/delete/{id}")
  @Produces("application/json")
  public Response delete(@PathParam("id") Integer id) {
    try {
      service.deleteById(id);

      return Response.status(200).entity(String.format("ID [%d] removido", id)).build();
    } catch (DeleteNotFound error) {
      return Response.status(Response.Status.NOT_FOUND)
          .entity(new ApplicationError(error.getMessage(), Response.Status.NOT_FOUND)).build();
    }

  }

}
