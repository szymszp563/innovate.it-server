package com.hackathon.server.service;

import com.hackathon.server.repository.AuthoritiesRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService {
    private final AuthoritiesRepository authoritiesRepository;

    public AuthoritiesService(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }
}
