package com.hackathon.server.rest.controller;

import com.hackathon.server.dto.InvestitionDto;
import com.hackathon.server.entity.Grade;
import com.hackathon.server.entity.Investition;
import com.hackathon.server.entity.InvestitionCategory;
import com.hackathon.server.entity.Users;
import com.hackathon.server.mappers.InvestitionMapper;
import com.hackathon.server.rest.exception.InvestitionNotFoundException;
import com.hackathon.server.rest.exception.UserNotFoundException;
import com.hackathon.server.rest.request.InvestitionRequest;
import com.hackathon.server.rest.response.BasicResponse;
import com.hackathon.server.rest.response.InvestitionsResponse;
import com.hackathon.server.service.GradeService;
import com.hackathon.server.service.InvestitionService;
import com.hackathon.server.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final UsersService usersService;
    private final GradeService gradeService;

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

    @GetMapping("/investitions/{username}")
    public ResponseEntity getInvestitionsGradedByUser(
            @PathVariable("username") String username
    ) throws UserNotFoundException, InvestitionNotFoundException {
        List<InvestitionDto> investitionDtos =
                investitionService.findInvestitionWithGradeOfUser(username)
                .stream().map(investitionMapper::investiotionToInvestitionDto).collect(Collectors.toList());

        InvestitionsResponse investitionResponse = getInvestitionsResponse(investitionDtos);
        return new ResponseEntity<>(investitionResponse, HttpStatus.OK);
    }

    @GetMapping("/investitions/notliked/{username}")
    public ResponseEntity getInvestitionsNotGradedByUser(
            @PathVariable("username") String username
    ) throws UserNotFoundException, InvestitionNotFoundException {
        List<InvestitionDto> investitionDtos =
                investitionService.findAllInvestitionsNotLikedByUser(username)
                        .stream().map(investitionMapper::investiotionToInvestitionDto).collect(Collectors.toList());

        InvestitionsResponse investitionResponse = getInvestitionsResponse(investitionDtos);
        return new ResponseEntity<>(investitionResponse, HttpStatus.OK);
    }


    @GetMapping("investitions/allCategories")
    public ResponseEntity getAllCategories(){
        return new ResponseEntity<>(InvestitionCategory.values(), HttpStatus.OK);
    }

    @GetMapping("investition/like/{investitionId}/{username}")
    public ResponseEntity likeInvestition(
            @PathVariable("username") String username,
            @PathVariable("investitionId") Integer investitionId
    ){
        gradeInvestition(username, investitionId, Boolean.TRUE);

        BasicResponse likeResponse = new InvestitionsResponse();
        likeResponse.setMessage("Like saved!");
        likeResponse.setStatus(HttpStatus.OK.value());
        likeResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(likeResponse, HttpStatus.OK);
    }

    @GetMapping("investition/dislike/{investitionId}/{username}")
    public ResponseEntity dislikeInvestition(
            @PathVariable("username") String username,
            @PathVariable("investitionId") Integer investitionId
    ){
        gradeInvestition(username, investitionId, Boolean.FALSE);

        BasicResponse dislikeResponse = new InvestitionsResponse();
        dislikeResponse.setMessage("Dislike saved!");
        dislikeResponse.setStatus(HttpStatus.OK.value());
        dislikeResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(dislikeResponse, HttpStatus.OK);
    }

    private InvestitionsResponse getInvestitionsResponse(List<InvestitionDto> investitionDtos) {
        InvestitionsResponse investitionResponse = new InvestitionsResponse();
        investitionResponse.setMessage("Fetched investitions");
        investitionResponse.setStatus(HttpStatus.OK.value());
        investitionResponse.setTimeStamp(System.currentTimeMillis());
        investitionResponse.setInvestitionDtos(investitionDtos);
        return investitionResponse;
    }

    private void gradeInvestition(String username, Integer investitionId, Boolean mark) {

        Investition investition = investitionService.findById(investitionId);
        Users user = usersService.findByUsername(username);

        Grade grade = Grade.builder().doLike(mark).build();
        user.addGrade(grade);
        investition.addGrade(grade);

        gradeService.save(grade);
    }
}

