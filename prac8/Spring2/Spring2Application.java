package com.example.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee[] employees = {
                new Employee("Alice", 55000),
                new Employee("Bob", 75000),
                new Employee("Charlie", 68000),
                new Employee("David", 89000),
                new Employee("Eve", 72000)
        };

        Employee highest = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].salary > highest.salary) {
                highest = employees[i];
            }
        }

        System.out.println("Highest Paid Employee: Name=" + highest.name + 
                ", Salary=" + highest.salary);
    }
}
