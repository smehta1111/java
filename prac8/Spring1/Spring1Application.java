package com.example.Spring1;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Spring1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring1Application.class, args);
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }
}
