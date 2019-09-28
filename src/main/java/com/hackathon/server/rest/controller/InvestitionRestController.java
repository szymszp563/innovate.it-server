package com.hackathon.server.rest.controller;

import com.hackathon.server.dto.InvestitionDto;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.rest.response.BasicResponse;
import com.hackathon.server.service.InvestitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InvestitionRestController {

    private final InvestitionService investitionService;

    public InvestitionRestController(InvestitionService investitionService) {
        this.investitionService = investitionService;
    }

    @PostMapping("/investition")
    public ResponseEntity registration(
             @RequestBody InvestitionDto investitionDto
    ) {
        investitionService.saveDto(investitionDto);

        BasicResponse investitionResponse = new BasicResponse();
        investitionResponse.setMessage("Investition saved");
        investitionResponse.setStatus(HttpStatus.OK.value());
        investitionResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(investitionResponse, HttpStatus.OK);
    }
}

