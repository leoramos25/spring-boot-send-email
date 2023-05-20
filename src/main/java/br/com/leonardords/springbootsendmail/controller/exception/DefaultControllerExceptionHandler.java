package br.com.leonardords.springbootsendmail.controller.exception;

import br.com.leonardords.springbootsendmail.controller.exception.model.DefaultError;
import br.com.leonardords.springbootsendmail.service.exception.MailException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class DefaultControllerExceptionHandler {

  @ExceptionHandler(MailException.class)
  public ResponseEntity<DefaultError> email(MailException ex, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    DefaultError error = new DefaultError();
    error.setTimestamp(Instant.now());
    error.setStatus(status.value());
    error.setError("Email error");
    error.setMessage(ex.getMessage());
    error.setPath(request.getRequestURI());
    return ResponseEntity.badRequest().body(error);
  }
}
