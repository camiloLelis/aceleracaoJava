package app.trybe.specialityapp.commons;

public class EditNotFound extends RuntimeException {

  /**
   * erro ao editar id inexistente.
   */
  private static final long serialVersionUID = 5016421011170395254L;

  public EditNotFound() {
    super("Não é possível editar, o ID informado não existe");
  }
}
