package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.DominioDao;
import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DominioService {

  @Inject
  DominioDao dominio;

  public List<TipoLancamento> getTipoLancamentos() {
    return dominio.getLancamentos();
  }

  public List<Parceiro> getParceiros() {
    return dominio.getParceiros();
  }

  public List<Produto> getProdutos() {
    return dominio.getProdutos();
  }
}
