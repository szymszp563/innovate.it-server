package com.hackathon.server.service;

import com.hackathon.server.entity.Users;
import com.hackathon.server.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void save (Users user) {
        usersRepository.save(user);
    }

    public List<Users> findAll() {return usersRepository.findAll();}
}
