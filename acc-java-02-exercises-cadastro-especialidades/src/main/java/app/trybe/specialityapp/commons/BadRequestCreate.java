package app.trybe.specialityapp.commons;

public class BadRequestCreate extends RuntimeException {

  /**
   *  erro de inserir registro com o id exposto.
   */
  private static final long serialVersionUID = -5447534954927361705L;

  public BadRequestCreate() {
    super("Não é permitido inserir novos registros com ID explícito");
  }
}
