package com.trybe.acc.java.caixaeletronico;

// referencia: https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {
  private Banco banco;
  private PessoaCliente pessoaCliente1;


  @BeforeEach
  void instanceBefore() {
    banco = new Banco();
    pessoaCliente1 =
        banco.adicionarPessoaCliente("Alexiania Pereira", "corrente", "842.074.410-77", "1234");

    banco.adicionarConta("poupanca", pessoaCliente1);
  }

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    String quant = banco.gerarNumeroNovaConta();
    assertEquals(10, quant.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    assertEquals(2, pessoaCliente1.retornaNumeroDeContas());
    assertEquals(1, banco.getPessoasClientes());
    assertEquals(PessoaCliente.class, pessoaCliente1.getClass()); // getClass é do java
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    assertNull(banco.pessoaClienteLogin("842.074.410-77", "1234_errado"));
    assertNotNull(banco.pessoaClienteLogin("842.074.410-77", "1234"));
    assertEquals(pessoaCliente1, banco.pessoaClienteLogin("842.074.410-77", "1234"));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    banco.depositar(pessoaCliente1, 1, 1000);
    banco.transferirFundos(pessoaCliente1, 1, 0, 500);
    assertEquals(500, pessoaCliente1.retornarSaldoContaEspecifica(0));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
   
    assertEquals(0.0, pessoaCliente1.retornarSaldoContaEspecifica(0));
  }
}
