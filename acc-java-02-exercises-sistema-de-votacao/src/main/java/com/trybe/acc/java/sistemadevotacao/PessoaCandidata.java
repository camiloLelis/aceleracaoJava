package com.trybe.acc.java.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Javadoc comment.
   */

  public PessoaCandidata(String nome, int numero) {
    this.numero = numero;
    this.votos = 0;
    this.setNome(nome);
  }

  @Override
  public String getNome() {
    // TODO Auto-generated method stub
    return this.nome;
  }

  @Override
  public void setNome(String nome) {
    // TODO Auto-generated method stub
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos() {
    this.votos += 1;
  }


}
