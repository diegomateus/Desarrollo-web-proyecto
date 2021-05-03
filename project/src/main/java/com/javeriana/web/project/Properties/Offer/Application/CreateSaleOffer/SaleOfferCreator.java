package com.javeriana.web.project.Properties.Offer.Application.CreateSaleOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.Services.PropertyValidator;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinder;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

public class SaleOfferCreator {

    private OfferRepository repository;
    private EventBus eventBus;
    private PropertyFinder propertyFinder;
    private PropertyValidator propertyValidator;

    public SaleOfferCreator(OfferRepository repository, EventBus eventBus, PropertyFinder propertyFinder) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.propertyFinder = propertyFinder;
        this.propertyValidator = new PropertyValidator(propertyFinder);
    }

    public void execute(String offerId, String propertyId, int price){
        if(propertyValidator.execute(propertyId)){
        Offer offer=Offer.createSaleOffer(new OfferId(offerId),new PropertyId(propertyId), new Price(price));
        repository.save(offer);
        this.eventBus.publish(offer.pullDomainEvents());
        }
    }

}
