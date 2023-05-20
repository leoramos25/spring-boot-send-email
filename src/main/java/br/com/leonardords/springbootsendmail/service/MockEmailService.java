package br.com.leonardords.springbootsendmail.service;

import br.com.leonardords.springbootsendmail.EmailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockEmailService implements EmailService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);

  @Override
  public void sendEmail(EmailDto mail) {
    LOGGER.info("Sending mail to: " + mail.getTo());
    LOGGER.info("Email sent");
  }
}
