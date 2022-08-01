package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Datacenter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DatacenterService implements ServiceInterface<Datacenter, Long> {

  @Override
  public void save(Datacenter s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();  
  }

  @Override
  public void update(Datacenter s) {
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
    Datacenter tobeDeleted = em.find(Datacenter.class, id);
    em.getTransaction().begin();
    em.remove(tobeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Datacenter> list() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Datacenter");
    return query.getResultList();
  }

  @Override
  public Datacenter findById(Long id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    return em.find(Datacenter.class, id);
  }

}