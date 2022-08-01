package com.trybe.acc.java.sistemadevotacao;

/* ref: https://www.w3schools.com/java/ref_string_equals.asp */

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Javadoc comment.
   */

  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean existe = false;
    for (int indexCandidato = 0; indexCandidato < pessoasCandidatas.size(); indexCandidato += 1) {
      PessoaCandidata candidato = pessoasCandidatas.get(indexCandidato);
      if (candidato.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        existe = true;
      }
    }
    if (!existe) {
      pessoasCandidatas.add(new PessoaCandidata(nome, numero));
    }
  }

  /**
   * Javadoc comment.
   */

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean existe = false;

    for (int indexEleitor = 0; indexEleitor < pessoasEleitoras.size(); indexEleitor += 1) {
      PessoaEleitora eleitor = pessoasEleitoras.get(indexEleitor);
      if (eleitor.getCpf().equals(cpf)) {
        existe = true;
        System.out.println("Pessoa eleitora já cadastrada!");
      }
    }
    if (!existe) {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }
  }

  /**
   * Javadoc comment.
   */

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    boolean registered = false;
    for (int index = 0; index < cpfComputado.size(); index += 1) {
      String cpf = cpfComputado.get(index);
      if (cpf.equals(cpfPessoaEleitora)) {
        registered = true;
        System.out.println("Pessoa eleitora já votou!");
      }
    }
    if (!registered) {
      for (int index = 0; index < pessoasCandidatas.size(); index += 1) {
        PessoaCandidata candidato = pessoasCandidatas.get(index);
        if (candidato.getNumero() == numeroPessoaCandidata) {
          setTotalVotos();
          candidato.setVotos();
          cpfComputado.add(cpfPessoaEleitora);
        }
      }
    }
  }

  /**
   * Javadoc comment.
   */

  public void mostrarResultado() {
    if (getTotalVotos() == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else if (getTotalVotos() > 0) {

      for (int indexVoto = 0; indexVoto < pessoasCandidatas.size(); indexVoto += 1) {
        PessoaCandidata candidato = pessoasCandidatas.get(indexVoto);
        System.out.println("Nome: " + candidato.getNome() + candidato.getVotos() + "( "
            + calcularPorcentagemVotos(indexVoto) + "%" + " )");
      }
      System.out.println("Total de votos: " + getTotalVotos());
    }
  }

  /**
   * Javadoc comment 2.
   */

  private double calcularPorcentagemVotos(int indiceCandidato) {
    int candidatoVotos = pessoasCandidatas.get(indiceCandidato).getVotos();
    double porcentagem = (double) Math.round(candidatoVotos * 100) / getTotalVotos();
    return porcentagem;
  }

  public int getTotalVotos() {
    return this.totalVotos;
  }

  public void setTotalVotos() {
    this.totalVotos += 1;
  }

}
