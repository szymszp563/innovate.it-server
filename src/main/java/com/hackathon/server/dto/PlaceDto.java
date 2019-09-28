package com.hackathon.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlaceDto {
    private String name;

    private String longitude;

    private String latitude;
}
