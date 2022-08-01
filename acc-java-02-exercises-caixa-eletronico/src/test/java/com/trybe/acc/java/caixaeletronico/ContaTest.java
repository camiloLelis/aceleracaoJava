package com.trybe.acc.java.caixaeletronico;

// ref : https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {
  private Conta conta;
  private Banco banco;
  private PessoaCliente pessoaCliente1;

  @BeforeEach
  void instanceBefore() {
    banco = new Banco();
    pessoaCliente1 =
        banco.adicionarPessoaCliente("Alexiania Pereira", "Poupança", "842.074.410-77", "1234");
    conta = new Conta("corrente", pessoaCliente1, banco);
  }

/*   @AfterEach
  void instanceAfter() {
    banco = null;
    conta = null;
    pessoaCliente1 = null;
  } */

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    String resumo = "Resumo das Contas da pessoa Camaragibe Oliveira:" + "\n"
        + "1) 1376245820 : R$4000.00 : Poupança";
    assertNotNull(conta.retornarResumoConta());
    assertNotNull(conta.getIdConta());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    conta.adicionarTransacao(2000, "Depósito");
    assertEquals(2000, conta.retornarSaldo());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    assertTrue(conta.retornarResumoConta().contains("0.00"));
    conta.adicionarTransacao(100, "Depósito");
    assertTrue(conta.retornarResumoConta().contains("100"));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    conta.adicionarTransacao(100, "Depósito");
    assertDoesNotThrow(()->{ conta.retornaExtrato();});
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    assertNotNull(conta.getIdConta());
    assertEquals(10, conta.getIdConta().length());
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    assertEquals(pessoaCliente1, conta.getPessoaCliente());
    assertNotNull(conta.getPessoaCliente());
  }

}
