package com.hackathon.server.repository;

import com.hackathon.server.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository  extends JpaRepository<Place, Integer> {
}
