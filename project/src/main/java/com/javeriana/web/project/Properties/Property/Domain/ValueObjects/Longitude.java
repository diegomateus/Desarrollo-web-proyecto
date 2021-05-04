package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class Longitude {
    private long value;

    public Longitude(){

    }

    public Longitude(long value) {
        this.value = value;
        this.validate(value);
    }

    private void validate(long value) {
        if(value<-180 || value>180){
            throw new InvalidNumber("Invalid longitude number");
        }
    }

    public long value(){
        return this.value;
    }
}
