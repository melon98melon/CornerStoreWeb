package com.csproj.CornerStore.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class template {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";

    }
}