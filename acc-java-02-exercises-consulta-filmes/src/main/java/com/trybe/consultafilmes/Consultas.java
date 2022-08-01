package com.trybe.consultafilmes;

import static java.util.Collections.emptyMap;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consultas {

  private final Collection<Filme> filmes;

  public Consultas(Collection<Filme> filmes) {
    this.filmes = filmes;
  }

  /**
   * Consulta 1: a partir da coleção de filmes desta classe, este método retorna o conjunto de
   * atores que interpretaram a si próprios em pelo menos um desses filmes.
   *
   * <p>
   * Considera-se "atores que interpretaram a si próprios" aqueles que têm o seu nome como uma das
   * chaves do Map `atoresPorPersonagem` e também como um dos itens pertencentes ao conjunto
   * associado a esta mesma chave.
   * </p>
   */
  public Set<String> atoresQueInterpretaramSiProprios() {
    Set<String> atores = new HashSet<>();
    filmes.stream().map(filme -> filme.atoresPorPersonagem)
        .forEach(atorPerso -> atorPerso.forEach((chave, valor) -> {
          if (valor.toString().contains(chave)) {
            atores.add(chave);
          }
        }));
    return atores;
  }

  /**
   * Consulta 2: a partir da coleção de filmes desta classe, este método retorna a lista de atores
   * que atuaram em pelo menos um filme de um determinado diretor. A lista retornada está disposta
   * em ordem alfabética.
   *
   * <p>
   * Considera-se que um ator tenha atuado em um filme de um determinado diretor se ele tem o seu
   * nome como um dos itens do campo `atores`, ao mesmo tempo em que o diretor em questão tem o seu
   * nome como um dos itens do campo `diretores` do mesmo filme.
   * </p>
   */
  public List<String> atoresQueAtuaramEmFilmesDoDiretorEmOrdemAlfabetica(String diretor) {
    List<String> result = filmes.stream()
        .flatMap(filme -> filme.atores.stream().filter(d -> filme.diretores.contains(diretor)))
        .distinct().sorted().collect(Collectors.toList());
    return result;
  }

  /**
   * Consulta 3: a partir da coleção de filmes desta classe, este método retorna a lista de filmes
   * em que pelo menos um dos diretores tenha atuado. A lista retornada está disposta em ordem de
   * lançamento, com os filmes mais recentes no início.
   *
   * <p>
   * Considera-se "filmes em que pelo menos um dos diretores tenha atuado" aqueles em que pelo menos
   * um dos itens do campo `diretores` também é um item do campo `atores`.
   * </p>
   */
  public List<Filme> filmesEmQuePeloMenosUmDiretorAtuouMaisRecentesPrimeiro() {
    // ref: https://www.geeksforgeeks.org/stream-findfirst-java-examples/
    List<Filme> diretorAtorEmFilme = filmes.stream()
        .filter(filme -> filme.atores.contains(filme.diretores.stream().findFirst().get()))
        .distinct().sorted(Comparator.comparingInt(f -> f.anoDeLancamento * -1))
        .collect(Collectors.toList());
    return diretorAtorEmFilme;
  }

 /*  public List<Filme> t() {
    List<Filme> diretorAtorEmFilme = filmes.stream()
        .filter(filme -> filme.atores.contains(filme.diretores.stream().forEach(d -> d.toString())))
        .collect(Collectors.toList());
    return diretorAtorEmFilme;
  } */

  public List<Filme> t() {
    List<Filme> diretorAtorEmFilme = filmes.stream()
        .filter(filme -> filme.atores.contains(filme.diretores.toString()))
        .collect(Collectors.toList());
    return diretorAtorEmFilme;
  }

  /**
   * Consulta 4: a partir da coleção de filmes desta classe, este método retorna um Map contendo
   * todos os filmes lançados em um determinado ano agrupados por categoria.
   *
   * <p>
   * Cada chave do Map representa uma categoria, enquanto cada valor representa o conjunto de filmes
   * que se encaixam na categoria da chave correspondente.
   * </p>
   */
  public Map<String, Set<Filme>> filmesLancadosNoAnoAgrupadosPorCategoria(int ano) {
    return emptyMap(); // TODO: Implementar (bônus).
  }
}
