package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class Latitude {
    private long value;

    public Latitude(){

    }

    public Latitude(long value) {
        this.value = value;
        this.validate(value);
    }

    private void validate(long value) {
        if(value<-90 || value>90) {
            throw new InvalidNumber("Invalid latitude number");
        }
    }

    public long value(){
        return this.value;
    }
}
