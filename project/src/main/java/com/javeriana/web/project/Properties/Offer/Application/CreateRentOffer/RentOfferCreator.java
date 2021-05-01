package com.javeriana.web.project.Properties.Offer.Application.CreateRentOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;
import com.javeriana.web.project.Shared.Domain.Offers.OfferActionEnum;

public class RentOfferCreator {

    private OfferRepository repository;
    private EventBus eventBus;

    public RentOfferCreator(OfferRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String offerId, String propertyId, int price){
        //TODO: Verificar existencia de propiedad
        Offer offer=Offer.createRentOffer(new OfferId(offerId),new PropertyId(propertyId), new Price(price));
        repository.save(offer);
        this.eventBus.publish(offer.pullDomainEvents());
    }


}
