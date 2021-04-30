package com.javeriana.web.project.Properties.Offer.Domain.Ports;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;

import java.util.Optional;

public interface OfferRepository {
    void save(Offer offer);
    Optional<Offer> find(String offerId);
    Offer update(Offer offer, OfferId offerId);

    //TODO: Add other methods
}
