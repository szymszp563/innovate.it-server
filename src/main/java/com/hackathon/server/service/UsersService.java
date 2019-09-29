package com.hackathon.server.service;

import com.hackathon.server.entity.Users;
import com.hackathon.server.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public void save(Users user) {
        usersRepository.save(user);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
