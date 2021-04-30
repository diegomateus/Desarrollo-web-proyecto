package com.javeriana.web.project.Properties.Offer.Application.UpdateOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.*;

import java.util.Optional;

public class OfferModifier {

    private OfferRepository repository;

    public OfferModifier(OfferRepository repository) {
        this.repository = repository;
    }

    public Offer execute(Offer offer, OfferId offerId){
        Optional<Offer> actualOffer =repository.find(offerId.toString());
        if(actualOffer.isEmpty()){
            throw new OfferNotExist("Offer with id: "+offerId+" not exist");
        }
        return repository.update(offer, offerId);
    }
}
