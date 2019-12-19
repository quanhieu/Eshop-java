package com.eshop;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailer = new JavaMailSenderImpl();
		mailer.setHost("smtp.gmail.com");
		mailer.setPort(587);
		mailer.setUsername("javapostoffice@gmail.com");
		mailer.setPassword("javapostoffice@2000");
		
		Properties props = mailer.getJavaMailProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		return mailer;
	}
}
