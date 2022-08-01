package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Torcedor;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class TorcedorDao extends GenericDao<Torcedor, Integer> {
  @Override
  public void salvar(Torcedor s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();  
  }

  @Override
  public void editar(Torcedor s) {
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
    Torcedor tobeDeleted = em.find(Torcedor.class, id);
    em.getTransaction().begin();
    em.remove(tobeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Torcedor> listar() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Torcedor");
    return query.getResultList();
  }

  @Override
  public Torcedor findById(Integer id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    return em.find(Torcedor.class, id);
  }
}
