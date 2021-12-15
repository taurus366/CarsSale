package com.example.carssale.event;

import com.example.carssale.config.JavaMailSender;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class RegisteredUserEmailSender {

    private final JavaMailSender javaMailSender;

    public RegisteredUserEmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @EventListener(UserRegisterSuccessfulEvent.class)
    public void sendRegisteredSuccessfulEmail(UserRegisterSuccessfulEvent userRegisterSuccessfulEvent) {

        System.out.println("SUCCESSFUL REGISTERED!"  + " " + userRegisterSuccessfulEvent.getEmail());

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(userRegisterSuccessfulEvent.getEmail());

        mail.setSubject("Successful Registered");
        mail.setText("Hello Dear, \n you have successful registered to our site !");
        javaMailSender.getJavaMailSender().send(mail);
    }
}
