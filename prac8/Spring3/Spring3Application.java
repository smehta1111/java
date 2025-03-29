package com.example.Spring3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class Spring3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring3Application.class, args);
    }

    @GetMapping("/")
    public String showForm() {
        return "index"; // Loads index.html
    }

    @GetMapping("/submit")
    public ModelAndView processForm(String username) {
        return new ModelAndView("result", "name", username);
    }
}
