package com.app.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.app.config.AppConfig;
import com.app.util.AppMailSender;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(AppConfig.class);
		AppMailSender mail = c.getBean("appMailSender",AppMailSender.class);
		
		String email="namdev15swatantra@gmail.com";
		String subject = "Hello Sample Email !!!!";
		String message = "Hello Swatantra Namdeo Welcome to My website";
		FileSystemResource file = new FileSystemResource("C:\\Users\\namde\\Pictures\\wallpaer\\01.jpg")  ;
		boolean flag = mail.sendEmail(email,subject,message,file);
		
		if(flag)
		{
			System.out.println("Done");
		}
		else
		{
			System.out.println("Sorry!!");
		}
	}

}
