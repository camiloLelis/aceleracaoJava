package com.betrybe.acc.java.bankaccount;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class.
 */
public class Application {

  /**
   * A simple get method.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    AccountNumberFormatter accountNumberFormatter = new AccountNumberFormatter();
    System.out.print("Informe o número da conta:\n");
    try {
      int accountNumber = scan.nextInt();
      System.out
          .println("Numero da conta: " + accountNumberFormatter.formatAccountNumber(accountNumber));
    } catch (InputMismatchException e) {
      System.out.println("Número da conta inválido!");
    } finally {
      scan.close();
    }

  }

}
