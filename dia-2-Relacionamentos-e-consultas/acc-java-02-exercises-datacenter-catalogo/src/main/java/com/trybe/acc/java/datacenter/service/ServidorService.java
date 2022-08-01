package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Servidor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ServidorService implements ServiceInterface<Servidor, Long> {

  @Override
  public void save(Servidor s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();  
  }

  @Override
  public void update(Servidor s) {
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
    Servidor tobeDeleted = em.find(Servidor.class, id);
    em.getTransaction().begin();
    em.remove(tobeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Servidor> list() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Servidor");
    return query.getResultList();
  }

  @Override
  public Servidor findById(Long id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    return em.find(Servidor.class, id);
  }

}
