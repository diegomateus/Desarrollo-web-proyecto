package com.javeriana.web.project.Properties.Offer.Domain;

import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;

import java.io.Serializable;

public class Offer implements Serializable {
    private OfferId offerId;
    private PropertyId propertyId;
    private Price price;
    private Action action;

    public Offer(OfferId offerId, PropertyId propertyId, Price price, Action action) {
        this.offerId = offerId;
        this.propertyId = propertyId;
        this.price = price;
        this.action = action;
    }
}
