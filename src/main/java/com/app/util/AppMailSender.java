package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class AppMailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String to,String sub,String text,FileSystemResource file)
	{
		boolean status = false;
		try {
			
			//1.Create Message Object
			MimeMessage message = mailSender.createMimeMessage();
			
			//2. Create Helper class Object
			
			MimeMessageHelper helper = new MimeMessageHelper(message,file!=null?true:false);
			
			//3.Compose Messsage
			helper.setTo("namdev15swatantra@gmail.com");
			helper.setFrom("namdev15swatantra@gmail.com");
			helper.setSubject("Hello !!");
			helper.setText("Welcome to mail spring");
			helper.addAttachment(file.getFilename(), file);
			
			//4. send mail
			mailSender.send(message);
			status = true;
		}catch(Exception e) {
			status = false;
			System.out.println(e);
		}
		return status;
	}

}
