package app.trybe.specialityapp.commons;

public class RegistryNotFound extends RuntimeException {

  /**
   * erro de registro inexistente.
   */
  private static final long serialVersionUID = 1L;

  public RegistryNotFound() {
    super("Nenhum registro foi encontrado!");
  }
}
