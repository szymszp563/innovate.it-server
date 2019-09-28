package com.hackathon.server.rest.exception;

public class ImageNotFoundException extends Exception {

    public ImageNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
