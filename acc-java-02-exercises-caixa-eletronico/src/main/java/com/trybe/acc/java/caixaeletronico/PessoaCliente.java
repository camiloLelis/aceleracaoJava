package com.trybe.acc.java.caixaeletronico;

// ref : https://github.com/tryber/acc-java-02-exercises-caixa-eletronico
// /tree/gabriel-suassuna-caixa-eletronico

import java.util.ArrayList;

public class PessoaCliente {

  private ArrayList<Conta> contas;
  private String nome;
  private String cpf;
  private String senha;

  /**
   * construtor.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.senha = senha;
    this.contas = new ArrayList<>();

  }

  public Integer retornaNumeroDeContas() {
    return contas.size();
  }

  public double retornarSaldoContaEspecifica(int i) {
    return getConta(i).retornarSaldo();
  }

  public Conta getConta(int i) {
    return this.contas.get(i);
  }

  /**
   * resumo. 
   */

  public void retornarResumoContas() {
    System.out.println("\n\n" + "Resumo das Contas da pessoa " + this.nome + ":\n");
    int index = 1;
    for (Conta conta : this.contas) {
      System.out.println(index + ") " + conta.retornarResumoConta() + "\n");
      index++;
    }
    System.out.println("\n");
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  public String getCpf() {
    return this.cpf;
  }

  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }

  public void adicionarTransacaoContaEspecifica(int i, double quantia, String operacao) {
    getConta(i).adicionarTransacao(quantia, operacao);
  }

  public void retornarExtratoContaEspecifica(int i) {
    Conta conta = getConta(i);
    conta.retornaExtrato();
  }

  public String retornarIdContaEspecifica(int i) {
    Conta conta = getConta(i);
    return conta.getIdConta();
  }

}
