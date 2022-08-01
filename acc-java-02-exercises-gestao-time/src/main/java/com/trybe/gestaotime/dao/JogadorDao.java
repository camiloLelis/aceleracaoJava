package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class JogadorDao extends GenericDao<Jogador, Integer> {
  @Override
  public void salvar(Jogador s) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();  
  }

  @Override
  public void editar(Jogador s) {
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
    Jogador tobeDeleted = em.find(Jogador.class, id);
    em.getTransaction().begin();
    em.remove(tobeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Jogador> listar() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Jogador");
    return query.getResultList();
  }

  @Override
  public Jogador findById(Integer id) {
    // TODO Auto-generated method stub
    EntityManager em = emf.createEntityManager();
    return em.find(Jogador.class, id);
  }

}
