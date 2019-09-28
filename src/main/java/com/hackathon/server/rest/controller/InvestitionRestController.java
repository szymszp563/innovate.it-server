package com.hackathon.server.rest.controller;

import com.hackathon.server.dto.InvestitionDto;
import com.hackathon.server.rest.response.BasicResponse;
import com.hackathon.server.service.InvestitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InvestitionRestController {

    private final InvestitionService investitionService;

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

    @GetMapping("/investition")
    public ResponseEntity getInvestitionWithCity(
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

