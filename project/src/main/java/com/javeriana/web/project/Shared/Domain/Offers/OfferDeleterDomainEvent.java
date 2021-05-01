package com.javeriana.web.project.Shared.Domain.Offers;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class OfferDeleterDomainEvent extends DomainEvent {

    public OfferDeleterDomainEvent() {
    }

    public OfferDeleterDomainEvent(String aggregateId) {
        super(aggregateId);
    }

    public OfferDeleterDomainEvent(String aggregateId, String eventId, String occurredOn) {
        super(aggregateId, eventId, occurredOn);
    }

    @Override
    public String eventName() {
        return "offer.deleter";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>();
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new OfferDeleterDomainEvent(aggregateId, eventId, occurredOn);
    }
}
