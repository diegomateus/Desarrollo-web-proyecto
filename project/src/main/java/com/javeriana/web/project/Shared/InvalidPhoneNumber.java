package com.javeriana.web.project.Shared;

public class InvalidPhoneNumber extends RuntimeException{
    public InvalidPhoneNumber(String message) {
        super(message);
    }
}
