package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Mated principal.
   */

  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI
    Scanner scanner = new Scanner(System.in);
    ArrayList<Short> personAge = new ArrayList<Short>();
    ArrayList<Short> kid = new ArrayList<Short>();
    ArrayList<Short> adult = new ArrayList<Short>();
    ArrayList<Short> senior = new ArrayList<Short>();
    byte option;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n" + "2 - Finalizar sistema e mostrar relatório\n");
      option = Byte.parseByte(scanner.next());
      if (option != 1 && option != 2) {
        System.out.println("Entre com uma opção válida");
      } else if (option == 1) {
        System.out.println("Entre com a idade:\n");
        Short idade = Short.parseShort(scanner.next());
        personAge.add(idade);

        if (idade < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
          kid.add(idade);
        } else if (idade >= 18 && idade < 50) {
          System.out.println("Pessoa adulta, catraca liberada!");
          adult.add(idade);
        } else {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
          senior.add(idade);
        }
      }
    } while (option != 2);
    Principal.printReport(personAge.size(), kid.size(), adult.size(), senior.size());
    scanner.close();
  }


  /**
   * print the report.
   */

  public static void printReport(Integer personAge, Integer kid, Integer adult, Integer senior) {
    DecimalFormat decimalFormat = new DecimalFormat("#0.#%");
    System.out.println("----- Quantidade -----\n" + "menores: " + kid + "\n" + "adultas: " + adult
        + "\n" + "a partir de 50: " + senior + "\n" + "\n" + "----- Percentual -----\n"
        + "menores: " + decimalFormat.format((float) kid / personAge) + "\n" + "adultas:"
        + decimalFormat.format((float) adult / personAge) + "\n" + "a partir de 50: "
        + decimalFormat.format((float) senior / personAge) + "\n" + "\n" + "TOTAL: " + personAge);
  }

}
