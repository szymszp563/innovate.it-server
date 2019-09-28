package com.hackathon.server.service;

import com.hackathon.server.dto.ImageDto;
import com.hackathon.server.entity.Image;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.repository.ImageRepository;
import com.hackathon.server.rest.exception.ImageNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save (Image image) {
        imageRepository.save(image);
    }

    public List<Image> findAll() {return imageRepository.findAll();}

    public Image findById(Integer id) throws ImageNotFoundException {
        Optional<Image> image = imageRepository.findById(id);
        if(!image.isPresent())
            throw new ImageNotFoundException("No image found!");
        return image.get();
    }
}
