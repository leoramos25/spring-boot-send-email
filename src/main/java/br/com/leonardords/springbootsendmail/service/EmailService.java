package br.com.leonardords.springbootsendmail.service;

import br.com.leonardords.springbootsendmail.EmailDto;

public interface EmailService {
  void sendEmail(EmailDto mail);
}
