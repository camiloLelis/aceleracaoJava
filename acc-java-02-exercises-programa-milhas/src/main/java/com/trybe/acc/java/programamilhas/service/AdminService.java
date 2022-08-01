package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.util.TokenUtil;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AdminService {

  @Inject
  TokenUtil tokenUtil;

  @Inject
  PessoaDao pessoaDao;

  /**
   * pegar saldos.
   */
  public List<SaldoResult> getSaldos(String token) throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);

    return pessoaDao.getSaldo();
  }

}
