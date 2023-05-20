package br.com.leonardords.springbootsendmail.configuration;

import br.com.leonardords.springbootsendmail.service.MailGunEmailService;
import br.com.leonardords.springbootsendmail.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@Profile("dev")
public class DevConfiguration {
  private final JavaMailSender mailSender;

  public DevConfiguration(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Bean
  public EmailService mailService() {
    return new MailGunEmailService(mailSender);
  }
}
