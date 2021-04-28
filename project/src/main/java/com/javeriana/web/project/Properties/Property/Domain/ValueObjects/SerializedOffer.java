package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;

import java.util.HashMap;
import java.util.Objects;

public class SerializedOffer {

    private String offerId;
    private Offer offer;

    public SerializedOffer() {
    }

    public SerializedOffer(String offerId, Offer offer) {
        this.offerId = offerId;
        this.offer = offer;
    }

    public Offer value(){
        return this.offer;
    }

    public HashMap<String,Object> data(){
        HashMap<String, Object> data= new HashMap<>(){{
            put("id",offerId);
            put("offer",offer);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializedOffer that = (SerializedOffer) o;
        return Objects.equals(offerId, that.offerId) && Objects.equals(offer, that.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, offer);
    }
}
