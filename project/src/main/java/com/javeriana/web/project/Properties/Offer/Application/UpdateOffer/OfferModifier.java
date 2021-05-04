package com.javeriana.web.project.Properties.Offer.Application.UpdateOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferDomainFinder;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.util.Optional;

public class OfferModifier {

    private OfferRepository repository;
    private OfferDomainFinder offerDomainFinder;
    private EventBus eventBus;

    public OfferModifier(OfferRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.offerDomainFinder = new OfferDomainFinder(repository);
        this.eventBus=eventBus;
    }

    public Offer execute(String offerId, int price){
        Optional<Offer> actualOffer=offerDomainFinder.execute(offerId);
        Offer offer=actualOffer.get();
        offer.updateOffer(new Price(price));
        repository.update(offerId,offer);
        this.eventBus.publish(offer.pullDomainEvents());
        return offer;
    }
}
