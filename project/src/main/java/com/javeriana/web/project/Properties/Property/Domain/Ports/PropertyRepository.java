package com.javeriana.web.project.Properties.Property.Domain.Ports;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import java.util.Optional;

public interface PropertyRepository {
    void save(Property property);
    Optional<Property> find (String propertyId);
    void update (String propertyId, Property property);
}
