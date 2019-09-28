package com.hackathon.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String username;

    private String password;

    private Boolean enabled;

    private List<InvestitionDto> investition;
}
