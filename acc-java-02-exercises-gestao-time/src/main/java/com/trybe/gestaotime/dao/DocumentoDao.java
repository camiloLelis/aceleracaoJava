package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Documento;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DocumentoDao extends GenericDao<Documento, Integer> {
  @Override
  public void salvar(Documento s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();  
  }

  @Override
  public void editar(Documento s) {
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
    Documento tobeDeleted = em.find(Documento.class, id);
    em.getTransaction().begin();
    em.remove(tobeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Documento> listar() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Documento");
    return query.getResultList();
  }

  @Override
  public Documento findById(Integer id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    return em.find(Documento.class, id);
  }

}
