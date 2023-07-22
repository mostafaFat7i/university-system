package com.example.notificationservice.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSenderService {

    private static final Logger infoLogger = LoggerFactory.getLogger("infoLogger");
    private static final Logger errorLogger = LoggerFactory.getLogger("errorLogger");
    private static final Logger debugLogger = LoggerFactory.getLogger("debugLogger");

    @Autowired
    private JavaMailSender mailSender;


    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("university_system@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        infoLogger.info("email is sent to: " + toEmail);
        System.out.println("Mail Send...");
    }


}
