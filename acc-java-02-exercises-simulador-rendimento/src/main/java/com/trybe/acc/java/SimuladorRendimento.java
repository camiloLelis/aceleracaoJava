package com.trybe.acc.java;

import java.time.LocalDate;

/**
 * classe para simular rendimentos.
 */

public class SimuladorRendimento {

  /**
   * calcula o tempo que o investimeto vai demorar para atingir. ou seja o tempo(n) juros compostos
   * : M = C.(1-i)^n .
   */

  public Integer simularRendimentoAnos(double valor, double valorObjetivo) {
    Integer anos = (int) Math.ceil(Math.log(valorObjetivo / valor) / Math.log(1.1));
    System.out.println(anos);
    LocalDate now = LocalDate.now();
    LocalDate data = now.plusYears(anos);
    Integer resposta = data.getYear();
    return resposta;
  }

  /**
   * método main para ver o retorno.
   */

  public static void main(String[] args) {
    SimuladorRendimento obj = new SimuladorRendimento();
    double inicial = 500;
    double objetivo = 5000;
    System.out.println("Com " + inicial + " seu rendimento será " + objetivo + " no ano "
        + obj.simularRendimentoAnos(inicial, objetivo));
  }

}
