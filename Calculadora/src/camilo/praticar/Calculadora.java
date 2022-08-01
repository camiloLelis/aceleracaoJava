package camilo.praticar;

public class Calculadora {

  public int somar(int x, int y) {
    return x + y;
  }

  public int subtrair(int x, int y) {
    return x - y;
  }

  public int dividir(int x, int y) {
    return x / y;
  }

  public boolean verificarDividendo(int y) {
    // TODO Auto-generated method stub
    if (y == 0) {
      return false;
    } else {
      return true;
    }
  }

}
