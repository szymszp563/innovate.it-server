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
    //@Pattern(regexp="/^[A-Za-z]+,[ ]?[A-Za-z]+{2,}$/", message = "Invalid city!")
    private String city;
    //@Pattern(regexp="/^[A-Za-z0-9]+(?:[_-][A-Za-z0-9]+)*$/", message = "Invalid country!")
    private String country;
    @Email(message = "Email not valid!")
    private String mail;
    private String name;
    private String surname;
    private String phone;
}
