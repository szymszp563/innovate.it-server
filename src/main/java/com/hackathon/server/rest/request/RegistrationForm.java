package com.hackathon.server.rest.request;

import lombok.*;

import javax.validation.constraints.Email;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationForm {

    //@Pattern(regexp="/^[A-Za-z0-9]+(?:[_-][A-Za-z0-9]+)*$/", message = "Invalid username!")
    private String username;
    private String password;
    private String authority;
    //@Email(message = "Email not valid!")
    //private String mail;
}
