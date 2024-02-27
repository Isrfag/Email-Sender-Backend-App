package com.emailSender.Send.Email.with.Springboot.services.impl;

import com.emailSender.Send.Email.with.Springboot.domain.dto.EmailDto;
import com.emailSender.Send.Email.with.Springboot.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImp implements EmailService{

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailServiceImp (JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender=javaMailSender;
        this.templateEngine=templateEngine;
    }

    @Override
    public void sendMail(EmailDto emailDto) throws MessagingException {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            //Destinatario
            helper.setTo(emailDto.getEmail_address());

            //Asunto
            helper.setSubject(emailDto.getSubject());

            //Mensaje
            Context context = new Context(); //El context tiene que ser de tymeleaf
            context.setVariable("message", emailDto.getMessage());
            String contentHtml = templateEngine.process("email", context);

            helper.setText(contentHtml, true);
            javaMailSender.send(message);
        }catch (Exception e) {
            throw  new RuntimeException("Failed when sending the email" + e.getMessage(), e);
        }


    }
}
