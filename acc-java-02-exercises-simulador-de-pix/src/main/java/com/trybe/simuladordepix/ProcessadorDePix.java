package com.trybe.simuladordepix;

import java.io.IOException;

public class ProcessadorDePix {

  private final Servidor servidor;

  public ProcessadorDePix(Servidor servidor) {
    this.servidor = servidor;
  }

  /**
   * Executa a operação do pix. Aqui é implementada a lógica de negócio
   * sem envolver as interações do aplicativo com a pessoa usuária.
   *
   * @param valor Valor em centavos a ser transferido.
   * @param chave Chave Pix do beneficiário da transação.
   *
   * @throws ErroDePix Erro de aplicação, caso ocorra qualquer inconformidade.
   * @throws IOException Caso aconteça algum problema relacionado à comunicação
   *                     entre o aplicativo e o servidor na nuvem.
   */
  public void executarPix(int valor, String chave) throws ErroDePix, IOException {
    // primeiro ver exeções do tipo Checked exception.
    if(valor < 1) {
      throw new ErroValorNaoPositivo();
    }
    // https://pt.stackoverflow.com/questions/4491/evitando-compara%c3%a7%c3%a3o-null-em-java.
    if(chave.isBlank()){
      throw new ErroChaveEmBranco();
    }
    // segundo abrir conexão.
    Conexao connect = servidor.abrirConexao();

    // try para exeções do tipo: Unchecked exception.
    try {
      String result = connect.enviarPix(valor, chave);
      if (result == CodigosDeRetorno.SALDO_INSUFICIENTE){
        throw new ErroSaldoInsuficiente():
      } 
      if (result == CodigosDeRetorno.CHAVE_PIX_NAO_ENCONTRADA){
        throw new ErroChaveNaoEncontrada();
      } 
      if (result == CodigosDeRetorno.SUCESSO) {
        return;
      } else {
        throw new ErroInterno();
      }

    } finally{
      // fechar connexão independente de retorno.
      connect.close();
    }
  }
}
