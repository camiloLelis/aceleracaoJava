package camilo.praticando;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TesteCotacao {

  @Test
  @DisplayName("Validando o método de seguro de moto.")
  public void testeSeguroMoto() {
    Cotacao objetoTeste = new Cotacao();
    assertEquals(250, objetoTeste.seguroMoto(5000));
  }

  @Test
  @DisplayName("Validando o método de seguro de carro.")
  public void testeSeguroCarro() {
    Cotacao objetoTeste = new Cotacao();
    assertEquals(7500, objetoTeste.seguroCarro(75000));
  }

  @Test
  @DisplayName("Validando o método de seguro de caminhão.")
  public void testeSeguroCaminhao() {
    Cotacao objetoTeste = new Cotacao();
    assertEquals(125000, objetoTeste.seguroCaminhao(500000));
  }

}
