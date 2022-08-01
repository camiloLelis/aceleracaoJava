package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * metodo para cria o cliente.
   * 
   * @param nome pessoa.
   * @param tipoConta se é corrente ou poupança.
   * @param cpf cpf valido.
   * @param senha senha com caracteres especiais(forte).
   * @return
   */

  public PessoaCliente adicionarPessoaCliente(String nome, String tipoConta, String cpf,
      String senha) {
    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    this.pessoasClientes.add(cliente);
    Conta conta = new Conta(tipoConta, cliente, this);
    cliente.adicionarConta(conta);
    this.contas.add(conta);
    return cliente;
  }

  /**
   * metodo para gerar um numer. o unico para cada conta. retorna string
   * 
   * @return
   */

  public String gerarNumeroNovaConta() {
    Random rand = new Random();
    StringBuilder numeroGerado = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      numeroGerado.append(String.valueOf(rand.nextInt(10)));
    }
    return numeroGerado.toString();
  }

  /**
   * retorna quantidade de clientes.
   * 
   * @return
   */

  public int getPessoasClientes() {
    return this.pessoasClientes.size();
  }

  /**
   * etapa de verificação de segurança da conta.
   * 
   * @param cpf cpf vadido.
   * @param senha senha forte.
   * @return
   */

  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente cliente : this.pessoasClientes) {
      if (cliente.getCpf().equals(cpf) && cliente.validarSenha(senha)) {
        return cliente;
      }
    }
    return null;
  }

  /**
   * incrementa o valor depositado ao saldo.
   * 
   * @param pessoaCliente1 obejeto pessoa.
   * @param paraConta para onde vai ser creditado.
   * @param quantia valor a ser depositado.
   */

  public void depositar(PessoaCliente pessoaCliente1, int paraConta, double quantia) {
    pessoaCliente1.adicionarTransacaoContaEspecifica(paraConta, quantia, "Depósito");
  }

  /**
   * transfere dinheiro de uma conta para outra.
   */

  public void transferirFundos(PessoaCliente pessoaCliente1, int daConta, int paraConta,
      double quantia) {
    pessoaCliente1.adicionarTransacaoContaEspecifica(daConta, quantia, "Saque");
    pessoaCliente1.adicionarTransacaoContaEspecifica(paraConta, quantia, "Depósito");

  }

  /**
   * retirada de dinheiro da conta.
   */

  public void sacar(PessoaCliente pessoaCliente1, int daConta, double quantia) {
    pessoaCliente1.adicionarTransacaoContaEspecifica(daConta, quantia, "Saque");
  }

  /**
   * exibe os dados(extrato).
   */

  public void mostrarExtrato(PessoaCliente pessoaCliente1, int conta) {
    pessoaCliente1.retornarExtratoContaEspecifica(conta);
  }

  /**
   * adiciona conta atraves da classe banco.
   */

  public void adicionarConta(String tipoConta, PessoaCliente pessoaCliente1) {
    Conta conta = new Conta(tipoConta, pessoaCliente1, this);
    pessoaCliente1.adicionarConta(conta);
    this.contas.add(conta);
  }
}
