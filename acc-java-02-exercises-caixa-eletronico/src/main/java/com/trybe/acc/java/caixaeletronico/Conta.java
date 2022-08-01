package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Locale;

// ref: https://github.com/tryber/acc-java-02-exercises-caixa-eletronico/
// tree/Barros99-caixa-eletronico
public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

  /**
   * construtor. 
   */

  public Conta(String tipoConta, PessoaCliente pessoaCliente1, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente1;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  public String retornarResumoConta() {
    return String.format(Locale.US, "Id:%s%nSaldo R$:%.2f%nTipo:%s%n", idConta, retornarSaldo(),
        tipoConta);
  }

  public String getIdConta() {
    return this.idConta;
  }

  /**
   * add as transaçoes. 
   */

  public void adicionarTransacao(double quantia, String operacao) {
    Transacao transacao = new Transacao(quantia, operacao);
    this.transacoes.add(transacao);
  }

  /**
  * retorno do saldo. 
  */

  public double retornarSaldo() {
    double saldo = 0.00d;
    for (Transacao transacao : this.transacoes) {
      if (((String) transacao.getDescricao()).contains("Depósito")) {
        saldo += transacao.getQuantia();
      } else if (((String) transacao.getDescricao()).contains("Saque")) {
        saldo -= transacao.getQuantia();
      }
    }
    return saldo;
  }

  /**
   * retorna pessoa. 
   */

  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }

  /**
  * retorna extrato. 
  */

  public void retornaExtrato() {
    for (Transacao transacao : this.transacoes) {
      System.out.println(transacao.retornarResumoTransacao());
    }
  }


}
