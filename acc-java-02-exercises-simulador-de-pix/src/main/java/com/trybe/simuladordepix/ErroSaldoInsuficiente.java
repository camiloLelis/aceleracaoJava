package com.trybe.simuladordepix;

public class ErroSaldoInsuficiente extends ErroDePix{

  /**
   * exceção customizada para saldo insuficiente.
  */
  public ErroSaldoInsuficiente() {
    super(Mensagens.SALDO_INSUFICIENTE);
  }
}
