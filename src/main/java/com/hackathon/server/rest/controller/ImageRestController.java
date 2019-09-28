package com.hackathon.server.rest.controller;

import com.hackathon.server.entity.Image;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.rest.exception.InvestitionNotFoundException;
import com.hackathon.server.rest.exception.handler.ImagesNotFoundException;
import com.hackathon.server.rest.request.InvestitionForImages;
import com.hackathon.server.rest.response.ImageIdsResponse;
import com.hackathon.server.service.ImageService;
import com.hackathon.server.service.InvestitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/urls")
public class ImageRestController {

    private final ImageService imageService;
    private final InvestitionService investitionService;

    public ImageRestController(ImageService imageService, InvestitionService investitionService) {
        this.imageService = imageService;
        this.investitionService = investitionService;
    }

    @PostMapping("/image")
    public ResponseEntity registration(
             @RequestBody InvestitionForImages investitionForImages
    ) throws InvestitionNotFoundException, ImagesNotFoundException {
        List<Integer> imageIds = new ArrayList<>();
        Investition investition = investitionService.findById(investitionForImages.getId());
        if(investition == null)
            throw new InvestitionNotFoundException("Wrong investition id! Investition not found!");
        investition = investitionService.getWithImages(investition);
        if(investition.getImages() == null || investition.getImages().size() <= 0)
            throw new ImagesNotFoundException("There are no images!");

        imageIds = investition.getImages().stream().map(Image::getId).collect(Collectors.toList());

        ImageIdsResponse imageIdsResponse = new ImageIdsResponse();
        imageIdsResponse.setMessage("Images ids");
        imageIdsResponse.setStatus(HttpStatus.OK.value());
        imageIdsResponse.setTimeStamp(System.currentTimeMillis());
        imageIdsResponse.setImageIds(imageIds);
        return new ResponseEntity<>(imageIdsResponse, HttpStatus.OK);
    }
}
