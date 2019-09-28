package com.hackathon.server.service;

import com.hackathon.server.dto.InvestitionDto;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.entity.Users;
import com.hackathon.server.mappers.InvestitionMapper;
import com.hackathon.server.repository.InvestitionRepository;
import com.hackathon.server.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvestitionService {
    private final InvestitionRepository investitionRepository;
    private final InvestitionMapper investitionMapper;

    private final UsersRepository usersRepository;

    public void save (Investition investition) {
        investitionRepository.save(investition);
    }

    public List<Investition> findAll() {return investitionRepository.findAll();}

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
        return  investitionRepository.findById(id).get();
    }
}

