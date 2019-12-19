package com.eshop.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailerService {
	@Autowired
	JavaMailSender mailer;
	
	public void send(String to, String subject, String body) throws Exception {
		MimeMessage mail = mailer.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
		helper.setFrom("songlong2k@gmail.com", "E-Shop Web Master");
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		helper.setReplyTo("songlong2k@gmail.com", "E-Shop Web Master");
		
		mailer.send(mail);
	}

	public void send(String sender, String receiver, String subject, String message) throws Exception {
		MimeMessage mail = mailer.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
		helper.setFrom(sender, sender);
		helper.setTo(receiver);
		helper.setSubject(subject);
		helper.setText(message, true);
		helper.setReplyTo(sender, sender);
		
		mailer.send(mail);
	}
}
