package com.javeriana.web.project.Properties.Offer.Application.CreateOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;

public class OfferCreator {
    private OfferRepository repository;

    public OfferCreator(OfferRepository repository) {
        this.repository = repository;
    }

    public void execute(OfferId offerId, PropertyId propertyId, Price price, Action action){
        Offer offer=new Offer(offerId, propertyId, price, action);
        repository.save(offer);
    }

    //TODO: evento crear serializabe
}
