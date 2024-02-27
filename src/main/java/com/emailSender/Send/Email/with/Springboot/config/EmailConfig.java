package com.emailSender.Send.Email.with.Springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
@PropertySource("classpath:email.properties") //Indicamos que use el archivo email
public class EmailConfig {

    @Value("${email.username}") //Esto lo sacamos del email properties
    private String userEmail;

    @Value ("${email.password}")
    private String password;

    private Properties getEmailProperties () {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true"); //Autorizacion
        properties.put("mail.smtp.starttls.enable", "true"); //
        properties.put("mail.smtp.host", "smtp.gmail.com"); //El tipo de email
        properties.put("mail.smtp.port", "587"); //El puerto de gmail

        return properties;
    }

    @Bean
    public JavaMailSender javaMailSender () {

        //Instanciamos la imp de java mail sender de spring
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setJavaMailProperties(getEmailProperties()); //Le pasamos las propiedades

        mailSender.setUsername(userEmail);
        mailSender.setPassword(password);

        return mailSender;
    }

    @Bean
    public ResourceLoader resourceLoader () {
        return new DefaultResourceLoader();
    }


}
