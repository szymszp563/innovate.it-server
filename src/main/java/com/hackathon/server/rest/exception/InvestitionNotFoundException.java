package com.hackathon.server.rest.exception;

public class InvestitionNotFoundException extends Exception {

    public InvestitionNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
