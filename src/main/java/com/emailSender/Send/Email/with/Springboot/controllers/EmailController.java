package com.emailSender.Send.Email.with.Springboot.controllers;

import com.emailSender.Send.Email.with.Springboot.domain.dto.EmailDto;
import com.emailSender.Send.Email.with.Springboot.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-an-email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail (@RequestBody EmailDto email) {
        try {

            emailService.sendMail(email);
            return new ResponseEntity<>("Email correctly sent", HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


}
