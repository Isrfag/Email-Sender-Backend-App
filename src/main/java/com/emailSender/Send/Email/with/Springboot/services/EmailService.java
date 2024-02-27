package com.emailSender.Send.Email.with.Springboot.services;

import com.emailSender.Send.Email.with.Springboot.domain.dto.EmailDto;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendMail (EmailDto emailDto) throws MessagingException;
}
