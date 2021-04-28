package com.javeriana.web.project.Properties.Property.Domain;

public class PropertyNotExist extends RuntimeException{
    public PropertyNotExist(String message) {
        super(message);
    }
}
