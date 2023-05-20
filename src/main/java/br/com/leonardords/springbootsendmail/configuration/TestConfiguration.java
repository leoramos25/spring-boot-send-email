package br.com.leonardords.springbootsendmail.configuration;

import br.com.leonardords.springbootsendmail.service.EmailService;
import br.com.leonardords.springbootsendmail.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
  @Bean
  public EmailService mailService() {
    return new MockEmailService();
  }
}
