package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response.Status;

public class ApplicationError {

  private String message;
  private Status status;

  public ApplicationError(String message, Status status) {
    this.message = message;
    this.status = status;
  }

  public String getMessage() {
    return this.message;
  }

  public Status getStatus() {
    return this.status;
  }

}
