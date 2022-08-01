package camilo.praticando;

public class Cotacao {

  public double seguroMoto(double valorMoto) {
    double valorSeguro = valorMoto * 0.05;
    return valorSeguro;
  }

  public double seguroCarro(double valorCarro) {
    double valorSeguro = valorCarro * 0.1;
    return valorSeguro;
  }

  public double seguroCaminhao(double valorCaminhao) {
    double valorSeguro = valorCaminhao * 0.25;
    return valorSeguro;
  }
}
