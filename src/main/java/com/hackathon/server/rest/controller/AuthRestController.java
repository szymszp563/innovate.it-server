package com.hackathon.server.rest.controller;

import com.hackathon.server.entity.Authorities;
import com.hackathon.server.entity.Users;
import com.hackathon.server.entity.privatekey.AuthoritiesPK;
import com.hackathon.server.rest.request.RegistrationForm;
import com.hackathon.server.rest.response.BasicResponse;
import com.hackathon.server.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String login() {
        return "Hello!";
    }

    @PostMapping("/registration")
    public ResponseEntity registration(
            @Valid @RequestBody RegistrationForm registrationForm
    ) {

        Users registered = new Users();

        AuthoritiesPK authoritiesPK = new AuthoritiesPK(registrationForm.getUsername(), registrationForm.getAuthority());
        Authorities authoritie = new Authorities(authoritiesPK);
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(authoritie);
        registered.setAuthorities(authorities);

        registered.setEnabled(Boolean.TRUE);

        registered.setUsername(registrationForm.getUsername());
        registered.setPassword("{noop}" + registrationForm.getPassword());

        usersService.save(registered);

        BasicResponse registerResponse = new BasicResponse();
        registerResponse.setMessage("Registered succesfully!");
        registerResponse.setStatus(HttpStatus.OK.value());
        registerResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(registerResponse, HttpStatus.OK);
    }
}
