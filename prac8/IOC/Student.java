package com.example.springioc;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String name = "John Doe";
	
	public void display() {
		System.out.println("Student name: " + name);
	}
}
