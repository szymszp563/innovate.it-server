package com.hackathon.server.service;

import com.hackathon.server.entity.Image;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
