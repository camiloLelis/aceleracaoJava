package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.AdminService;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
@ApplicationScoped
public class AdminController {

  @Inject
  AdminService adminService;

  @POST
  @Path("/saldos")
  @Produces(MediaType.APPLICATION_JSON)
  public Response adminSaldos(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    List<SaldoResult> saldo = adminService.getSaldos(token);
    return Response.ok(saldo).build();
  }
}
