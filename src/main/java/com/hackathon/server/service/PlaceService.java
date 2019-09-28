package com.hackathon.server.service;

import com.hackathon.server.entity.Place;
import com.hackathon.server.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public void save (Place place) {
        placeRepository.save(place);
    }

    public List<Place> findAll() {return placeRepository.findAll();}
}
