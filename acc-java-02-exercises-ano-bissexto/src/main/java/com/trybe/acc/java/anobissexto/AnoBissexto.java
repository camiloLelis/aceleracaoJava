package com.trybe.acc.java.anobissexto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * classe para datas.
 */

public class AnoBissexto {

  /**
   * método para verificar anobissexo.
   */
  public boolean identificarAnoBissexto(int ano) {
    LocalDate bi = LocalDate.parse(ano + "-01-01");
    return bi.isLeapYear();
  }

  /**
   * método para verificar pŕoximo anobissexo.
   */
  public int identificarProximoAnoBissexto(String data) {
    String formatoData = "dd/MM/yyyy";
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern(formatoData);
    LocalDate dataFormata = LocalDate.parse(data, formatador); 
    boolean ano = dataFormata.isLeapYear();
    if (ano == true) {
      return dataFormata.getYear();
    }
    int somaAnos = 1;
    while (ano == false) {
      LocalDate teste = dataFormata.plusYears(somaAnos);
      ano = teste.isLeapYear();
      if (ano == false) {
        somaAnos++;
      }
    }
    return dataFormata.plusYears(somaAnos).getYear();
  }

  /**
   * método main para testar.
   */
  public static void main(String[] args) {
    AnoBissexto ano = new AnoBissexto();
    System.out.println(ano.identificarAnoBissexto(2024));
    System.out.println(ano.identificarProximoAnoBissexto("22/12/2021"));
  }
}
