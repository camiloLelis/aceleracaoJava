package com.trybe.simuladordepix;

public class ErroValorNaoPositivo extends ErroDePix {

  /**
   * exceção customizada para valor não positivo.
  */
  public ErroValorNaoPositivo() {
    super(Mensagens.VALOR_NAO_POSITIVO);
  }
}
