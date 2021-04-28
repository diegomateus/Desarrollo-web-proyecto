package com.javeriana.web.project.Shared.Domain;

import java.util.Objects;

public class IntegerValueObject {

    protected int value;

    public IntegerValueObject(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}
