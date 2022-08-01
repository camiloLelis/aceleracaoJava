package com.trybe.acc.java.minhasseries.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InterceptorHandle {

  /**
   * error servidor.
   */
  @ExceptionHandler(ErroInesperadoException.class)
  public ResponseEntity<ApplicationError> serverError(ErroInesperadoException error) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ApplicationError(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
  }

  /**
   * serie name já existe .
   */
  @ExceptionHandler(SerieExistenteException.class)
  public ResponseEntity<ApplicationError> serieAlreadyExistsError(SerieExistenteException error) {

    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new ApplicationError(error.getMessage(), HttpStatus.CONFLICT));
  }

  /**
   * episodio não existe para serie informada.
   */
  @ExceptionHandler(EpisodioExistenteException.class)
  public ResponseEntity<ApplicationError> existingEpisodeError(EpisodioExistenteException error) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new ApplicationError(error.getMessage(), HttpStatus.CONFLICT));
  }

  /**
   * não encontrada.
   */
  @ExceptionHandler(SerieNaoEncontradaException.class)
  public ResponseEntity<ApplicationError> notFoundSerieError(SerieNaoEncontradaException error) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ApplicationError(error.getMessage(), HttpStatus.NOT_FOUND));
  }
}
