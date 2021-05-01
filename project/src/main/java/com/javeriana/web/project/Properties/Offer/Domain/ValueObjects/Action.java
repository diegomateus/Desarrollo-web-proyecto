package com.javeriana.web.project.Properties.Offer.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.Offers.OfferActionEnum;

public class Action {
    private OfferActionEnum value;

    public Action(OfferActionEnum value) {
        this.value = value;
    }

    public OfferActionEnum value(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return value == action.value;
    }
}
