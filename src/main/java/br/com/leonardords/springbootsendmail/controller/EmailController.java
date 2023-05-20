package br.com.leonardords.springbootsendmail.controller;

import br.com.leonardords.springbootsendmail.EmailDto;
import br.com.leonardords.springbootsendmail.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mails")
public class EmailController {

  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping
  public ResponseEntity<Void> send(@RequestBody EmailDto mail) {
    emailService.sendEmail(mail);
    return ResponseEntity.noContent().build();
  }
}

