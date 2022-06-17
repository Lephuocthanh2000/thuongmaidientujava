package com.ThanhLe.thuongmaidientu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl sender=new JavaMailSenderImpl();
        sender.setDefaultEncoding("utf-8");
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername("HoTroKhachHang6868@gmail.com");
        sender.setPassword("221200Ta");
        Properties props=sender.getJavaMailProperties();
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.smtp.auth","true");
        props.setProperty("mail.smtp.starttls.enable","true");
        props.setProperty("mail.debug","true");
        return sender;
    }
}
