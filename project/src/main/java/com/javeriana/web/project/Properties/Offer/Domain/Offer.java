package com.javeriana.web.project.Properties.Offer.Domain;

import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Shared.Bus.Aggregate.AggregateRoot;
import com.javeriana.web.project.Shared.Domain.Offers.OfferActionEnum;
import com.javeriana.web.project.Shared.Domain.Offers.OfferCreatorDomainEvent;
import com.javeriana.web.project.Shared.Domain.Offers.OfferDeleterDomainEvent;
import com.javeriana.web.project.Shared.Domain.Offers.OfferModifierDomainEvent;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class Offer extends AggregateRoot implements Serializable {
    private OfferId offerId;
    private PropertyId propertyId;
    private Price price;
    private Action action;

    public Offer(OfferId offerId, PropertyId propertyId, Price price, Action action) {
        this.offerId = offerId;
        this.propertyId = propertyId;
        this.price = price;
        this.action = action;
        this.record(new OfferCreatorDomainEvent(offerId.value(),price.value(),action.value(),propertyId.value()));
    }

    public void updateOffer(Price price) {
        this.price=price;
        this.record(new OfferModifierDomainEvent(this.offerId.value(),this.price.value(),this.action.value(),this.propertyId.value()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(offerId, offer.offerId) &&
                Objects.equals(propertyId, offer.propertyId) &&
                Objects.equals(price, offer.price) &&
                Objects.equals(action, offer.action);
    }

    public OfferId getOfferId() {
        return offerId;
    }

    public PropertyId getPropertyId() {
        return propertyId;
    }

    public Price getPrice() {
        return price;
    }

    public Action getAction() {
        return action;
    }

    public void deleteOffer(Offer offer) {
        offer.record(new OfferDeleterDomainEvent(this.offerId.value()));
    }
}
