package br.com.leonardords.springbootsendmail.service;

import br.com.leonardords.springbootsendmail.dto.EmailDto;
import br.com.leonardords.springbootsendmail.service.exception.MailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailGunEmailService implements EmailService {
  private final JavaMailSender mailSender;

  public MailGunEmailService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void sendEmail(EmailDto mail) {
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      helper.setFrom(mail.getFromEmail());
      helper.setTo(mail.getTo());
      helper.setSubject(mail.getSubject());
      helper.setText(mail.getBody(), true);

      mailSender.send(message);
    } catch (MessagingException ex) {
      throw new MailException(ex.getMessage());
    }
  }
}
