package com.hackathon.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GradeDto {
    private Integer id;

    private boolean doLike;

    private UserDto user;

    private InvestitionDto investition;
}
