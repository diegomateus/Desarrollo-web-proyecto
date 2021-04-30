package com.javeriana.web.project.Properties.Property.Application.AddOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedOffer;

public class AddOffer {

    private PropertyRepository repository;

    public AddOffer(PropertyRepository repository) {
        this.repository = repository;
    }

    public void execute(Property property, Offer offer){
        SerializedOffer serializedOffer = new SerializedOffer(offer.getOfferId().toString(),offer.getPrice().value(),offer.getAction().toString());
        property.addOffer(serializedOffer);
        repository.save(property);
    }
}
