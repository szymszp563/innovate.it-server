package com.hackathon.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class InvestitionDto {

    private Integer id;

    private String title;

    private String description;

    private List<ImageDto> images;

    private String creator;

    private PlaceDto place;
}
