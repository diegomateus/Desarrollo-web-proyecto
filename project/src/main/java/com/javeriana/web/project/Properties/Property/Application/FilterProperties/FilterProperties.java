package com.javeriana.web.project.Properties.Property.Application.FilterProperties;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyFilter;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.List;

public class FilterProperties {

    private PropertyRepository repository;
    private PropertyFilter propertiesFilterer;

    public FilterProperties(PropertyRepository repository, PropertyFilter
            propertiesFilterer) {
        this.repository = repository;
        this.propertiesFilterer = propertiesFilterer;
    }

    public List<Property> execute(BedroomsNumber bedroomsNumber,
                                  BathroomsNumber bathroomsNumber,
                                  BuiltArea builtArea,
                                  Condition condition,
                                  DeliveryDate deliveryDate,
                                  Location location,
                                  PrivateArea privateArea
                                  ){
        return propertiesFilterer.execute(bedroomsNumber,bathroomsNumber,builtArea,condition,deliveryDate,location,privateArea);
    }
}
