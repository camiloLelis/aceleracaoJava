package com.trybe.acc.java.sistemadevotacao;

/*
 * referencia: https://github.com/tryber/acc-java-02-exercises-sistema-de-votacao/
 * blob/gusttavocaruso-sistema-votacao/src/main/java/com/trybe/acc/java
 * /sistemadevotacao/Principal.java
 */

import java.util.Scanner;

public class Principal {

  /**
   * Javadoc comment.
   */
  public static void main(String[] args) {

    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scan = new Scanner(System.in);

    String nome;
    String cpf;
    int numero;

    boolean menuOpen = true;
    short option;
    do {
      System.out.println("Cadastrar pessoa candidata? \n" + "1 - Sim \n" + "2 - Não \n"
          + "Entre com o número correspondente à opção desejada:");
      option = scan.nextShort();

      if (option == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        nome = scan.next();

        System.out.println("Entre com o numero da pessoa candidata:");
        numero = scan.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      } else if (option == 2) {
        menuOpen = false;
      } else {
        System.out.println("Opção inválida.");
      }

    } while (menuOpen);

    menuOpen = true;

    do {
      System.out.println("Cadastrar pessoa eleitora? \n" + "1 - Sim \n" + "2 - Não \n"
          + "Entre com o número correspondente à opção desejada:");
      option = scan.nextShort();

      if (option == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        nome = scan.next();

        System.out.println("Entre com o cpf da pessoa eleitora:");
        cpf = scan.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      } else if (option == 2) {
        menuOpen = false;
      } else {
        System.out.println("Opção inválida.");
      }

    } while (menuOpen);

    menuOpen = true;

    do {
      System.out.println("Entre com o número correspondente à opção desejada: \n" + "1 - Votar \n"
          + "2 - Resultado Parcial \n" + "3 - Finalizar Votação");
      option = scan.nextShort();

      if (option == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        cpf = scan.next();

        System.out.println("Entre com o número da pessoa candidata:");
        numero = scan.nextInt();

        gerenciamentoVotacao.votar(cpf, numero);
      } else if (option == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (option == 3) {
        gerenciamentoVotacao.mostrarResultado();
        menuOpen = false;
      } else {
        System.out.println("Opção inválida.");
      }

    } while (menuOpen);

    scan.close();
  }
}
