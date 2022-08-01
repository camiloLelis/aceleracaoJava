package com.betrybe.acc.java.bankaccount;

import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.Length;

/**
 * AccountNumberFormatter.
 */
public class AccountNumberFormatter {

  /**
   * Formata o número da conta.
   *
   * @param literalAccountNumber número da conta
   */
  public String formatAccountNumber(int literalAccountNumber) {
    String result = String.valueOf(literalAccountNumber);
    if (result.length() > 6) {
      return StringUtils.right(result, 6);
    }
    if (result.length() < 6) {
      return StringUtils.leftPad(result, 6, "0");
    }
    if (result.length() == 6) {
      return result;
    }
    return "inválido!";
  }

}