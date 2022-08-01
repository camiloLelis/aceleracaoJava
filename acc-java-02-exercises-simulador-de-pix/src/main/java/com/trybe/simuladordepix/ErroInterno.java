package com.trybe.simuladordepix;

public class ErroInterno extends ErroDePix{
/**
   * exceção customizada erro interno servidor.
  */
  public ErroInterno() {
    super(Mensagens.ERRO_INTERNO);
  }
}
