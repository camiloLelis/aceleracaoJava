package com.trybe.acc.java.minhasseries.commons;

public class SerieNaoEncontradaException extends RuntimeException {

  public SerieNaoEncontradaException() {
    super("Série não encontrada");   
  } 

}
