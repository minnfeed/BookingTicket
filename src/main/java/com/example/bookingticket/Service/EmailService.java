//package com.example.bookingticket.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    public void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("your-email@gmail.com");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//
//        javaMailSender.send(message);
//    }
//}