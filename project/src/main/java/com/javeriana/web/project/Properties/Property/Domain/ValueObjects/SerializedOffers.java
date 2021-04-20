package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;

import java.util.ArrayList;

public class SerializedOffers {
    private ArrayList<Offer> value;

    public SerializedOffers(ArrayList<Offer> value) {
        this.value = value;
    }

    public ArrayList<Offer> value(){
        return this.value;
    }
}
