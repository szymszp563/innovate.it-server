package com.hackathon.server.rest.controller;

import com.hackathon.server.dto.InvestitionDto;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.mappers.InvestitionMapper;
import com.hackathon.server.rest.exception.InvestitionNotFoundException;
import com.hackathon.server.rest.exception.UserNotFoundException;
import com.hackathon.server.rest.request.InvestitionRequest;
import com.hackathon.server.rest.response.BasicResponse;
import com.hackathon.server.rest.response.InvestitionsResponse;
import com.hackathon.server.service.InvestitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InvestitionRestController {

    private final InvestitionService investitionService;
    private final InvestitionMapper investitionMapper;

    @PostMapping("/investition")
    public ResponseEntity saveInvestition(
            @RequestBody InvestitionDto investitionDto
    ) {
        investitionService.saveDto(investitionDto);

        BasicResponse investitionResponse = new BasicResponse();
        investitionResponse.setMessage("Investition saved");
        investitionResponse.setStatus(HttpStatus.OK.value());
        investitionResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(investitionResponse, HttpStatus.OK);
    }

    @PostMapping("/investitions")
    public ResponseEntity getInvestitions(
            @RequestBody InvestitionRequest investitionRequest
    ) throws UserNotFoundException, InvestitionNotFoundException {
        if (investitionRequest.getCity() != null && investitionRequest.getCity().isPresent()) {
            List<Investition> investitions = investitionService.findByCity(investitionRequest.getCity().get());
            List<InvestitionDto> investitionDtos =
                    investitions.stream().map(investitionMapper::investiotionToInvestitionDto).collect(Collectors.toList());

            InvestitionsResponse investitionResponse = getInvestitionsResponse(investitionDtos);
            return new ResponseEntity<>(investitionResponse, HttpStatus.OK);
        } else {
            List<InvestitionDto> investitionDtos =
                    investitionService.findByCreator(investitionRequest.getCreator().get())
                            .stream().map(investitionMapper::investiotionToInvestitionDto).collect(Collectors.toList());

            InvestitionsResponse investitionResponse = getInvestitionsResponse(investitionDtos);
            return new ResponseEntity<>(investitionResponse, HttpStatus.OK);
        }

    }

    private InvestitionsResponse getInvestitionsResponse(List<InvestitionDto> investitionDtos) {
        InvestitionsResponse investitionResponse = new InvestitionsResponse();
        investitionResponse.setMessage("Fetched investitions");
        investitionResponse.setStatus(HttpStatus.OK.value());
        investitionResponse.setTimeStamp(System.currentTimeMillis());
        investitionResponse.setInvestitionDtos(investitionDtos);
        return investitionResponse;
    }
}

