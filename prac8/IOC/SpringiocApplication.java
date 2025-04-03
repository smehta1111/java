package com.example.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringiocApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringiocApplication.class, args);
		context.getBean(Student.class).display();
	}

}
