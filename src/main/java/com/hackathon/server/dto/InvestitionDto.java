package com.hackathon.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class InvestitionDto {
    private String title;

    private String description;

    private String picture;

    private String creator;
}
