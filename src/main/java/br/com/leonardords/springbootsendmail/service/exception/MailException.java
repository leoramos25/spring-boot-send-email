package br.com.leonardords.springbootsendmail.service.exception;

import java.io.Serial;

public class MailException extends RuntimeException {
  @Serial
  private static final long serialVersionUID = 2378747990417120065L;

  public MailException(String message) {
    super(message);
  }
}
