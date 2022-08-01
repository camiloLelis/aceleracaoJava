package com.trybe.acc.java.sistemadevotacao;

public class PessoaEleitora extends Pessoa {

  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    this.setNome(nome);
    this.setCpf(cpf);
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
