package com.javeriana.web.project.Properties.Offer.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.OfferActionEnum;

public class Action {
    private OfferActionEnum value;

    public Action(OfferActionEnum value) {
        this.value = value;
    }

    public OfferActionEnum value(){
        return this.value;
    }
}
