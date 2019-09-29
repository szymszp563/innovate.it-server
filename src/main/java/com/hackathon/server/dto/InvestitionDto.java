package com.hackathon.server.dto;

import com.hackathon.server.entity.InvestitionCategory;
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

    private String shortDescription;

    private InvestitionCategory category;

    private List<ImageDto> images;

    private String creator;

    private PlaceDto place;
}
