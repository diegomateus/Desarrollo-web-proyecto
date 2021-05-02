package com.javeriana.web.project.Properties.Offer.Domain.ValueObjects;

public class OfferNotExist extends RuntimeException{
    public OfferNotExist(String message) {
        super(message);
    }
}
