package com.hackathon.server.service;

import com.hackathon.server.dto.InvestitionDto;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.entity.Users;
import com.hackathon.server.mappers.InvestitionMapper;
import com.hackathon.server.repository.InvestitionRepository;
import com.hackathon.server.repository.UsersRepository;
import com.hackathon.server.rest.exception.InvestitionNotFoundException;
import com.hackathon.server.rest.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InvestitionService {
    private final InvestitionRepository investitionRepository;
    private final InvestitionMapper investitionMapper;

    private final UsersRepository usersRepository;

    public void save(Investition investition) {
        investitionRepository.save(investition);
    }

    public List<Investition> findAll() {
        return investitionRepository.findAll();
    }

    public void saveDto(InvestitionDto investitionDto) {
        Investition investition = investitionMapper.investitionDtoToInvestition(investitionDto);
        Users user = usersRepository.findByUsername(investitionDto.getCreator());
        investition.setCreator(user);
        investitionRepository.save(investition);
    }

    public Investition finByTitle(String title) {
        return investitionRepository.findByTitle(title);
    }

    public Investition getWithImages(Investition investition) {
        investition.getImages();
        return investition;
    }

    public Investition findById(Integer id) {
        return investitionRepository.findById(id).get();
    }

    public List<Investition> findByCity(String city) {
        return investitionRepository.findByCity(city);
    }

    public List<Investition> findByCreator(String creator) throws InvestitionNotFoundException, UserNotFoundException {
        Users users = usersRepository.findByUsername(creator);
        if(users == null)
            throw new UserNotFoundException("User with given username: " + creator + " does not exist!");
        List<Investition> investitions = investitionRepository.findByCreator(users);
        if(investitions == null || investitions.size() <= 0)
            throw new InvestitionNotFoundException("No investition found!");
        return investitions;
    }

    public List<Investition> findInvestitionWithGradeOfUser(String username) throws UserNotFoundException, InvestitionNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if(user == null)
            throw new UserNotFoundException("User with given username: " + username + " does not exist!");
        List<Investition> investitions = investitionRepository.findInvestitionWithGradeOfUser(username);
        if(investitions == null || investitions.size() <= 0)
            throw new InvestitionNotFoundException("No investition found!");
        return investitions;
    }

    public List<Investition> findAllInvestitionsNotLikedByUser(String username) throws UserNotFoundException, InvestitionNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if(user == null)
            throw new UserNotFoundException("User with given username: " + username + " does not exist!");
        List<Investition> investitions = investitionRepository.findAllInvestitionsNotLikedByUser(username);
        if(investitions == null || investitions.size() <= 0)
            throw new InvestitionNotFoundException("No investition found!");
        return investitions;
    }

    public List<Investition> findInvestitionsLikedByUser(String username) throws UserNotFoundException, InvestitionNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if(user == null)
            throw new UserNotFoundException("User with given username: " + username + " does not exist!");
        List<Investition> investitions = investitionRepository.findInvestitionLikedByUser(username);
        if(investitions == null || investitions.size() <= 0)
            new LinkedList<>();
        return investitions;
    }
}

