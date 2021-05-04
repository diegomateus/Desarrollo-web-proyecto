package com.javeriana.web.project.Properties.Property.Domain.Ports;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import java.util.List;
import java.util.Optional;

public interface PropertyRepository {
    void save(Property property);
    Optional<Property> find(String propertyId);
    List<Property> filter(BedroomsNumber minBedroomsNumber,
                          BathroomsNumber minBathroomsNumber,
                          BuiltArea minBuiltArea, BuiltArea maxBuiltArea,
                          Condition condition,
                          PrivateArea minPrivateArea, PrivateArea maxPrivateArea);

    Optional<List<Property>> all();

    //TODO: Add other methods
    void update (String propertyId, Property property);
}
