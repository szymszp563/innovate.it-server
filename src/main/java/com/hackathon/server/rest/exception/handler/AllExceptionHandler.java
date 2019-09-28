package com.hackathon.server.rest.exception.handler;

import com.hackathon.server.rest.response.BasicResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleException(Exception exc) {

        BasicResponse genericResponse = new BasicResponse();
        genericResponse.setMessage(exc.getMessage());
        genericResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        genericResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }
}