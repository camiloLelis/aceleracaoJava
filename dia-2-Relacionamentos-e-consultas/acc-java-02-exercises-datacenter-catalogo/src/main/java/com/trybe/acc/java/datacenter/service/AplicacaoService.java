package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class AplicacaoService implements ServiceInterface<Aplicacao, Long> {

  @Override
  public void save(Aplicacao s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();  
  }

  @Override
  public void update(Aplicacao s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
    em.close();   
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    Aplicacao tobeDeleted = em.find(Aplicacao.class, id);
    em.getTransaction().begin();
    em.remove(tobeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Aplicacao> list() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Aplicacao");
    return query.getResultList();
  }

  @Override
  public Aplicacao findById(Long id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    return em.find(Aplicacao.class, id);
  }

}
