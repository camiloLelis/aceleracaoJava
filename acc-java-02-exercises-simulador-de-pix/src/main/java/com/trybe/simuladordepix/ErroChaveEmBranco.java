package com.trybe.simuladordepix;

public class ErroChaveEmBranco extends ErroDePix {

  /**
   * exceção customizada para chave em branco.
  */
  public ErroChaveEmBranco() {
    super(Mensagens.CHAVE_EM_BRANCO);
  }
}
