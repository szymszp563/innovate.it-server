package com.hackathon.server.mappers;

import com.hackathon.server.dto.PlaceDto;
import com.hackathon.server.entity.Place;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    Place placeDtoToPlace(PlaceDto dto);

    PlaceDto placeToPlaceDto(Place entity);

}
