package com.hackathon.server.mappers;

import com.hackathon.server.dto.ImageDto;
import com.hackathon.server.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    Image imageDtoToImage(ImageDto dto);

    ImageDto imageToTimageDto(Image image);
}
