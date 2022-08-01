package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import com.trybe.acc.java.programamilhas.service.DominioService;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/dominio")
@ApplicationScoped
public class DominioController {
  @Inject
  DominioService service;

  @GET
  @Path("/tipolancamento")
  public Response tipoLancamento() {
    List<TipoLancamento> lancamentos = service.getTipoLancamentos();
    return Response.ok(lancamentos).build();
  }

  @GET
  @Path("/parceiro")
  public Response parceiros() {
    List<Parceiro> parceiros = service.getParceiros();
    return Response.ok(parceiros).build();
  }

  @GET
  @Path("/produto")
  public Response produtos() {
    List<Produto> produtos = service.getProdutos();
    return Response.ok(produtos).build();
  }
}
