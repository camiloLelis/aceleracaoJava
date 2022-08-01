package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Transacao {
  private double quantia;
  private String instante;
  private String operacao;
  private Conta conta;

  /**
   * Method.
   */

  public Transacao(double quantia, String operacao) {
    this.quantia = quantia;
    this.operacao = operacao;
    this.instante = retornarInstante();
  }

  /**
   * Method.
   */

  public Object getDescricao() {
    return this.operacao;
  }

  /**
   * Method.
   */

  public double getQuantia() {
    return quantia;
  }

  /**
   * Method.
   */

  public String retornarResumoTransacao() {
    return String.format(Locale.US, "Data: %s%nValor R$:%.2f%nAction:%s", instante, quantia,
        operacao);
  }

  /**
   * Method.
   */

  public String retornarInstante() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
  }

  /**
   * Method.
   */

  public Conta getConta() {
    return conta;
  }
}
