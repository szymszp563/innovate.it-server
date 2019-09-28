package com.hackathon.server.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @GetMapping("/hello")
    public String sayHello() {

        return "Hello world";
    }
}
