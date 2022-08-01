package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PessoaService {
  @Inject
  PessoaDao pessoaDao;

  /**
   * inserir usuário(pessoa) na base de dados.
   */
  public void insertPessoa(LoginDto login) 
      throws InvalidKeySpecException, NoSuchAlgorithmException {
    pessoaDao.insert(login);
  }

  /**
   * deletar usuário(pessoa) na base de dados.
   */
  public void remover(String token) throws AcessoNaoAutorizadoException {
    pessoaDao.remover(token);
  }
}
