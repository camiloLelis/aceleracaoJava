package app.trybe.specialityapp.commons;

public class DeleteNotFound extends RuntimeException {

  /**
   * erro ao deletar id inexistente.
   */
  private static final long serialVersionUID = -148002726128304384L;

  public DeleteNotFound() {
    super("Não é possível deletar, o ID informado não existe");
  }
}
