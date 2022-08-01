package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ApplicationScoped
public class DominioDao {

  @Inject
  EntityManager entityManager;

  /**
   * pegar todos os lançamentos .
   */
  @SuppressWarnings("unchecked")
  public List<TipoLancamento> getLancamentos() {
    String hql = "from " + TipoLancamento.class.getSimpleName();
    Query query = entityManager.createQuery(hql);
    return query.getResultList();
  }

  /**
   *  pegar todos os lançamentos.
   */
  @SuppressWarnings("unchecked")
  public List<Parceiro> getParceiros() {
    String hql = "from " + Parceiro.class.getSimpleName();
    Query query = entityManager.createQuery(hql);
    return query.getResultList();
  }

  /**
   *  pegar todos os lançamentos.
   */
  @SuppressWarnings("unchecked")
  public List<Produto> getProdutos() {
    String hql = "from " + Produto.class.getSimpleName();
    Query query = entityManager.createQuery(hql);
    return query.getResultList();
  }

}
