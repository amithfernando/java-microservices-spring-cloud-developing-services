package de.ksbrwsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Exercise1Application {

    @GetMapping("/greet")
    public String greet() {
        return "Hello, World!";
    }

    @PostMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        String greeting = "Hello, " + name + "!";
        return greeting;
    }

    public static void main(String[] args) {
        SpringApplication.run(Exercise1Application.class, args);
    }
}
