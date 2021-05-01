package com.javeriana.web.project.Properties.Property.Domain.Ports;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedOffer;

import java.util.Optional;

public interface PropertyRepository {
    void save(Property property);
    Optional<Property> find(String propertyId);
    Property updateSerializedOffer(String propertyId, Property property);

    //TODO: Add other methods
}
