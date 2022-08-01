package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class TimeDao extends GenericDao<Time, Integer> {
  @Override
  public void salvar(Time s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();  
  }

  @Override
  public void editar(Time s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
    em.close();   
  }

  @Override
  public void deletar(Integer id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    Time tobeDeleted = em.find(Time.class, id);
    em.getTransaction().begin();
    em.remove(tobeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Time> listar() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Time");
    return query.getResultList();
  }

  @Override
  public Time findById(Integer id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    return em.find(Time.class, id);
  }

}
