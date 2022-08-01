package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados na pasta de
   * saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas Pasta em que serão colocados os arquivos gerados no formato requerido pelo
   *        subsistema.
   *
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    // TODO: Implementar.

    if (!pastaDeSaidas.exists()) {
      pastaDeSaidas.mkdir();
    }

    for (File f : pastaDeEntradas.listFiles()) {
      FileReader leitorArquivo = new FileReader(f);
      BufferedReader bufferedLeitor = new BufferedReader(leitorArquivo);
      String conteudoLinha = bufferedLeitor.readLine();
      FileWriter escritorArquivo = new FileWriter(pastaDeSaidas + "/" + f.getName());
      BufferedWriter bufferedEscritor = new BufferedWriter(escritorArquivo);
      while (conteudoLinha != null) {
        String linha = linhaFormatte(conteudoLinha);
        bufferedEscritor.write(linha);
        bufferedEscritor.newLine();
        bufferedEscritor.flush();
        conteudoLinha = bufferedLeitor.readLine();
      }

      this.fecharObjetos(leitorArquivo, bufferedLeitor, escritorArquivo, bufferedEscritor);

    }


  }

  /**
   * formata linhas.
   */
  public static String linhaFormatte(String conteudoLinha) {
    // TODO Auto-generated method stub
    String[] linha = conteudoLinha.split(",");
    String nome = "";
    if (linha[0].equals("Nome completo")) {
      nome = linha[0];
    } else {
      nome = linha[0].toUpperCase();
    }
    String data = formataData(linha);
    String cpf = formataCpf(linha);
    return String.join(",", nome, data, linha[2], cpf);
  }

  /**
   * formata cpf.
   */
  public static String formataCpf(String[] linha) {
    String cpf = linha[3];

    if (cpf.equals("CPF")) {
      return cpf;
    }

    String a = cpf.substring(0, 3);
    String b = cpf.substring(3, 6);
    String c = cpf.substring(6, 9);
    String d = cpf.substring(9, 11);

    return a + "." + b + "." + c + "-" + d;
    // https://www.guj.com.br/t/metodo-format-da-classe-string/78623
  }

  /**
   * formata data.
   */

  public static String formataData(String[] eachLine) {
    String dataNasc = eachLine[1];

    if (dataNasc.equals("Data de nascimento")) {
      return dataNasc;
    }

    String[] dmy = dataNasc.split("/");
    String ymd = String.join("-", dmy[2], dmy[1], dmy[0]);

    return ymd;
    // referencia: https://github.com/tryber/acc-java-02-exercises-conversor-csv/blob/
    // gusttavocaruso-csv/src/main/java/com/trybe/conversorcsv/Conversor.java
  }

  /**
   * fecha os abertos pelas classes de leitura e escrita.
   */

  private void fecharObjetos(FileReader fileReader, BufferedReader bufferedReader,
      FileWriter fileWriter, BufferedWriter bufferedWriter) {
    try {
      fileReader.close();
      bufferedReader.close();
      fileWriter.close();
      bufferedWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
