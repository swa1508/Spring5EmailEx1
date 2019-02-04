package com.app.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages="com.app")
public class AppConfig {
	
	//1. java mail sender
	
	@Bean
	public JavaMailSenderImpl mail()
	{
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost("smtp.gmail.com");
		mail.setPort(587);
		mail.setUsername("swatantra15081993@gmail.com");
		mail.setPassword("15081993");
		mail.setJavaMailProperties(props());
		return mail;	
	}

	
	public Properties props() {
		Properties p = new Properties();
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.auth", "true");
		return p;
	}

}
