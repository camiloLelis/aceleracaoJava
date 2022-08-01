package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// https://github.com/tryber/acc-java-02-exercises-cadastro-especialidades/tree/gabriel-suassuna-cadastro-especialidade

@RestControllerAdvice
public class InterceptorHandle {
  
  /**
   * erro interno do servidor.
   */

  @ExceptionHandler(Exception.class)
  public Response globalExceptionHandler(Exception error) {
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
    .entity(new ApplicationError(error.getMessage(), Response.Status.INTERNAL_SERVER_ERROR))
    .build();
  }
  
  /**
   *  id exposto ao criar.
   */

  @ExceptionHandler(BadRequestCreate.class)
  public Response createBadRequest(BadRequestCreate error) {
    return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ApplicationError(error.getMessage(), Response.Status.BAD_REQUEST)).build();
  }

  /**
   * registros não encontrados.
   */

  @ExceptionHandler(RegistryNotFound.class)
  public Response notFoundProfessional(RegistryNotFound error) {
    return Response.status(Response.Status.NOT_FOUND)
    .entity(new ApplicationError(error.getMessage(), Response.Status.NOT_FOUND)).build();
  }
  

  /**
   * id inexistente ao editar.
   */

  @ExceptionHandler(EditNotFound.class)
  public Response notFoundToEdit(EditNotFound error) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity(new ApplicationError(error.getMessage(), Response.Status.NOT_FOUND)).build();
  }

  /**
   *  id inexistente ao deletar.
   */

  @ExceptionHandler(DeleteNotFound.class)
  public Response notFoundToDelete(EditNotFound error) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity(new ApplicationError(error.getMessage(), Response.Status.NOT_FOUND)).build();
  }

}
