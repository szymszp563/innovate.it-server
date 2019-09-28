package com.hackathon.server.rest.controller;

import com.hackathon.server.dto.ImageDto;
import com.hackathon.server.entity.Image;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.mappers.ImageMapper;
import com.hackathon.server.rest.exception.ImageNotFoundException;
import com.hackathon.server.rest.exception.InvestitionNotFoundException;
import com.hackathon.server.rest.exception.ImagesNotFoundException;
import com.hackathon.server.rest.request.InvestitionForImages;
import com.hackathon.server.rest.response.ImageIdsResponse;
import com.hackathon.server.rest.response.ImageResponse;
import com.hackathon.server.service.ImageService;
import com.hackathon.server.service.InvestitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/urls")
public class ImageRestController {

    private final ImageService imageService;
    private final InvestitionService investitionService;
    private final ImageMapper imageMapper;

    public ImageRestController(ImageService imageService, InvestitionService investitionService, ImageMapper imageMapper) {
        this.imageService = imageService;
        this.investitionService = investitionService;
        this.imageMapper = imageMapper;
    }

    @GetMapping("/images/{id}")
    public ResponseEntity getImagesIds(
            @PathVariable("id") Integer id
    ) throws InvestitionNotFoundException, ImagesNotFoundException {
        Investition investition = investitionService.findById(id);
        if(investition == null)
            throw new InvestitionNotFoundException("Wrong investition id! Investition not found!");
        investition = investitionService.getWithImages(investition);
        if(investition.getImages() == null || investition.getImages().size() <= 0)
            throw new ImagesNotFoundException("There are no images!");

        List<Integer> imageIds = investition.getImages().stream().map(Image::getId).collect(Collectors.toList());

        ImageIdsResponse imageIdsResponse = new ImageIdsResponse();
        imageIdsResponse.setMessage("Images ids");
        imageIdsResponse.setStatus(HttpStatus.OK.value());
        imageIdsResponse.setTimeStamp(System.currentTimeMillis());
        imageIdsResponse.setImageIds(imageIds);
        return new ResponseEntity<>(imageIdsResponse, HttpStatus.OK);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity getImageRaw(
            @PathVariable("id") Integer id
    ) throws ImageNotFoundException {
        ImageDto imageDto = imageMapper.imageToTimageDto(imageService.findById(id));

        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setMessage("Images ids");
        imageResponse.setStatus(HttpStatus.OK.value());
        imageResponse.setTimeStamp(System.currentTimeMillis());
        imageResponse.setImageDto(imageDto);
        return new ResponseEntity<>(imageResponse, HttpStatus.OK);
    }
}