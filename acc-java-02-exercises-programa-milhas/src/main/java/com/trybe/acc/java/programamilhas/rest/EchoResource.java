package com.trybe.acc.java.programamilhas.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/echo")
@ApplicationScoped
public class EchoResource {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response hello() {
    return Response.ok("Olá!").build();
  }
}
