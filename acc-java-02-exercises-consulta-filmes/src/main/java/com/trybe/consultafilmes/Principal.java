package com.trybe.consultafilmes;

import java.util.List;
import java.util.Set;

public class Principal {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   */
  public static void main(String[] args) {
    Consultas consultas = new Consultas(Filmes.todos());
    List<Filme> resultados =
        consultas.filmesEmQuePeloMenosUmDiretorAtuouMaisRecentesPrimeiro();
    List<Filme> r =
        consultas.t();
    System.out.println(resultados);
    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
    System.out.println(r);
    
    

    // System.out.println(Filmes.oGrandeDitador.atoresPorPersonagem.get("Benzino Napaloni"));
    // so para o PR
  }
}
