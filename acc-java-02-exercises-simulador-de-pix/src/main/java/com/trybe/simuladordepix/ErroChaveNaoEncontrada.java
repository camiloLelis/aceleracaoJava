package com.trybe.simuladordepix;

public class ErroChaveNaoEncontrada extends ErroDePix{
   /**
   * exceção customizada para chave não encontrada.
  */
  public ErroChaveNaoEncontrada() {
    super(Mensagens.CHAVE_NAO_ENCONTRADA);
  }
}
