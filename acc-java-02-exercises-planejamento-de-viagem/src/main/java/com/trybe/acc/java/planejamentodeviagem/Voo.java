package com.trybe.acc.java.planejamentodeviagem;

public class Voo {
  private int tempoVoo;

  /**
   * Método para retornar tempo de Voo.
   * 
   */
  public int retornarTempoVoo(double distanciaKm) {

    int duracao = (int) Math.round(distanciaKm / 700.0);

    /* Implemente sua solução aqui */
    return duracao;
  }

  /**
   * Método para retornar informaçao do Voo.
   * 
   */
  public String retornarInformacaoVoo(String embarque, String origem, String desembarque,
      String destino) {
    /* Implemente sua solução aqui */
    String result = "Partida: " + embarque + "\n" + "Origem: " + origem + "\n" + "\n" + "Chegada: "
        + desembarque + "\n" + "Destino: " + destino + "\n\n";
    return result;
  }
}
