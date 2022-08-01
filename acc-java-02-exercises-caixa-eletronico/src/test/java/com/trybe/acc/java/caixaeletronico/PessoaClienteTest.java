package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {
  private PessoaCliente pessoaCliente;
  /*
   * private Banco banco; private Conta conta;
   */

  @BeforeEach
  void instanceBefore() {
    pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
  }

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    assertNotNull(pessoaCliente.getCpf());
    assertEquals(PessoaCliente.class, pessoaCliente.getClass());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    pessoaCliente.adicionarConta(new Conta("Poupança", pessoaCliente, new Banco()));
    assertEquals(1, pessoaCliente.retornaNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    pessoaCliente.adicionarConta(new Conta("Poupança", pessoaCliente, new Banco()));
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 10, "Depósito");
    assertEquals(10, pessoaCliente.retornarSaldoContaEspecifica(0));
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    pessoaCliente.adicionarConta(new Conta("Poupança", pessoaCliente, new Banco()));
    assertNotNull(pessoaCliente.retornarIdContaEspecifica(0));
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    pessoaCliente.adicionarConta(new Conta("Poupança", pessoaCliente, new Banco()));
    assertEquals(0, pessoaCliente.getConta(0).retornarSaldo());
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 10, "Depósito");
    assertDoesNotThrow(()->{ pessoaCliente.retornarExtratoContaEspecifica(0);;});
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    pessoaCliente.adicionarConta(new Conta("Poupança", pessoaCliente, new Banco()));
    assertEquals(0, pessoaCliente.getConta(0).retornarSaldo());
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 10, "Depósito");
    assertEquals(10, pessoaCliente.getConta(0).retornarSaldo());

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    assertTrue(pessoaCliente.validarSenha("1234"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    pessoaCliente.adicionarConta(new Conta("Poupança", pessoaCliente, new Banco()));
    assertEquals(0, pessoaCliente.getConta(0).retornarSaldo());
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 10, "Depósito");
    assertDoesNotThrow(()->{ pessoaCliente.retornarResumoContas();});
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    assertEquals("842.074.410-77", pessoaCliente.getCpf());

  }

}
