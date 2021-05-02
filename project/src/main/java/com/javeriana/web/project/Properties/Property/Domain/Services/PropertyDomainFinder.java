package com.javeriana.web.project.Properties.Property.Domain.Services;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PropertyNotExist;

import java.util.Optional;

public class PropertyDomainFinder {

    private PropertyRepository repository;

    public PropertyDomainFinder(PropertyRepository repository) {
        this.repository = repository;
    }

    public Optional<Property> execute(String propertyId){
        Optional<Property> property = repository.find(propertyId);
        if(property.isEmpty()){
            throw new PropertyNotExist("Offer with id: "+propertyId+" not exist");
        }
        return property;
    }
}
