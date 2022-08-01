package com.trybe.acc.java.planejamentodeviagem;

public class Viagem {
  private String embarque;
  private String origem;
  private String destino;
  private double distanciaKm;
  private Voo voo;

  /**
   * Método construtor da classe.
   * 
   */
  public Viagem(String embarque, String origem, String destino, double distanciaKm) {
    /* Implemente sua solução aqui (você pode ter que alterar o construtor) */
    this.embarque = embarque;
    this.origem = origem;
    this.destino = destino;
    this.distanciaKm = distanciaKm;
    this.voo = new Voo();
  }

  /**
   * Método para retorno do horário de Desembarque no Destino.
   * 
   */
  public String retonarDesembarqueHorarioLocalDestino() {
    Tempo tempoViagem =
        new Tempo(this.embarque, this.origem, this.destino, this.retornarDuracaoVoo());
    return tempoViagem.retonarDesembarqueHorarioLocalDestino();
  }

  // aqui consideramos que um aviao percorre em media 700 km a cada hora
  /**
   * Método para retorno da informaçao da viagem.
   * 
   */
  public int retornarDuracaoVoo() {
    /* Implemente sua solução aqui */
    int teste = this.voo.retornarTempoVoo(this.distanciaKm);
    return teste;
  }

  /**
   * Método para retorno da informaçao da viagem.
   */
  public String retornarInformacaoViagem() {
    Tempo tempoViagem =
        new Tempo(this.embarque, this.origem, this.destino, this.retornarDuracaoVoo());
    String horaOrigem = tempoViagem.retonarDesembarqueHorarioLocalOrigem();
    String horaDestino = tempoViagem.retonarDesembarqueHorarioLocalDestino();
    String vooInforma =
        this.voo.retornarInformacaoVoo(horaDestino, horaOrigem, horaOrigem, horaDestino);

    String msg = vooInforma + "Atenção: o desembarque em " + this.destino + " será: " + horaDestino
        + " no horário de " + this.destino + " e " + horaOrigem + " no horário de " + this.embarque;
    return msg;
  }
}
