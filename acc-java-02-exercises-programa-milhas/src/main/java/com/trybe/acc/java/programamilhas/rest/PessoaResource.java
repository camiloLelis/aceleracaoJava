package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.service.PessoaService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/pessoa")
@ApplicationScoped
public class PessoaResource {
  @Inject
  PessoaService pessoa;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response insertPessoa(LoginDto login) throws 
      InvalidKeySpecException, NoSuchAlgorithmException, NoSuchFieldException {
    pessoa.insertPessoa(login);
    return Response.status(Status.OK).build();
  }

  /**
  * delete.
  */
  @DELETE
  public Response remover(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    pessoa.remover(token);
    return Response.status(200).build();
  }
}
