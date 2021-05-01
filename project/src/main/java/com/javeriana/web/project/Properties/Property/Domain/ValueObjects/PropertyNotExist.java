package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

public class PropertyNotExist extends RuntimeException{

    public PropertyNotExist(String message) {
        super(message);
    }
}
