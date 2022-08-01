package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.bytebuddy.asm.Advice.Return;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {
  EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("crudHibernatePU");

  public void salvar(T s) {}

  public void editar(T s) {}

  public void deletar(I id) {}

  public List<T> listar() {
    return null;
  }

  public T findById(I id) {
    return null;
  }

}
