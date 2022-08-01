package camilo.praticar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Eu sou a classe de teste da calculadora")
class TesteCalculadora {

  // método para testar o método somar da classe Calculadora
  @Test
  @DisplayName("testando o método somar...")
  public void testeSomar() {
    Calculadora cal = new Calculadora();
    assertEquals(34, cal.somar(32, 2));
  }

  // método para testar o método subtrair da classe Calculadora
  @Test
  @DisplayName("testando o método subtrair...")
  public void testeSubtrair() {
    Calculadora cal = new Calculadora();
    assertEquals(1, cal.subtrair(3, 2));
  }

  // método para testar o método dividir da classe Calculadora
  @Test
  @DisplayName("testando o método dividir...")
  public void testeDividir() {
    Calculadora cal = new Calculadora();
    assertEquals(3, cal.dividir(6, 2));
  }

  // método para testar o método verificarDividendo da classe Calculadora
  @Test
  @DisplayName("testando a exceção do método dividir...")
  public void testeDividirExcecao() {
    Calculadora cal = new Calculadora();
    assertThrows(ArithmeticException.class, () -> {
      cal.dividir(3, 0);
    });
  }

}
