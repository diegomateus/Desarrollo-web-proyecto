package com.javeriana.web.project.Properties.Offer.Domain.Services;

import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.PropertyNotFound;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinder;
import com.javeriana.web.project.Properties.Property.Domain.Property;

import java.util.Optional;

public class PropertyValidator {

    private PropertyFinder propertyFinder;

    public PropertyValidator(PropertyFinder propertyFinder) {
        this.propertyFinder = propertyFinder;
    }

    public boolean execute(String propertyId){
        Property property = propertyFinder.execute(propertyId);
        if(property==null){
            throw new PropertyNotFound("Property with id "+propertyId+" not exist");
        }
        return true;
    }
}
