package com.javeriana.web.project.Properties.Property.Application.UpdateSerializedOffer;

import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Offers.OfferCreatorDomainEvent;
import com.javeriana.web.project.Shared.Domain.Offers.OfferModifierDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({OfferModifierDomainEvent.class})
public final class UpdateSerializedOfferOnOfferModified {

    private SerializedOfferModifier serializedOfferModifier;

    public UpdateSerializedOfferOnOfferModified(SerializedOfferModifier serializedOfferModifier) {
        this.serializedOfferModifier = serializedOfferModifier;
    }

    @EventListener
    public void on(OfferCreatorDomainEvent event){
        serializedOfferModifier.execute(event.aggregateId(),event.getPropertyID(),event.getPrice(),event.getAction());
    }
}
