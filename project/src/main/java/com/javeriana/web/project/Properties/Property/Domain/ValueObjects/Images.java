package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import java.util.ArrayList;

public class Images {
    private ArrayList<String> value;

    public Images(ArrayList<String> value) {
        this.value = value;
    }

    public ArrayList<String> value() {
        return value;
    }
}
