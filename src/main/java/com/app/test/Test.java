package com.app.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.app.config.AppConfig;
import com.app.util.AppMailSender;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(AppConfig.class);
		AppMailSender mail = c.getBean("appMailSender",AppMailSender.class);
		
		FileSystemResource file = new FileSystemResource("C:\\Users\\namde\\Pictures\\wallpaer\\01.jpg")  ;
		boolean flag = mail.sendEmail("jayant.raikwar03@gmail.com","Sample Test mail!!","Welcome to the Spring Email",file);
		
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
