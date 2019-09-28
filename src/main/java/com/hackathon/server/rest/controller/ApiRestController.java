package com.hackathon.server.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @GetMapping("/hello")
    public String sayHello() {

        return "Hello world";
    }
}
