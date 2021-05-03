package com.javeriana.web.project.Properties.Property.Application.FilterProperties;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyFilter;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.List;

public class FilterProperties {

    private PropertyRepository repository;
    private PropertyFilter propertiesFilter;

    public FilterProperties(PropertyRepository repository, PropertyFilter
            propertiesFilterer) {
        this.repository = repository;
        this.propertiesFilter = propertiesFilterer;
    }

    public List<Property> execute(BedroomsNumber minBedroomsNumber,
                                  BathroomsNumber minBathroomsNumber,
                                  BuiltArea minBuiltArea, BuiltArea maxBuiltArea,
                                  Condition condition,
                                  PrivateArea minPrivateArea, PrivateArea maxPrivateArea
                                  ){
        return propertiesFilter.execute(minBedroomsNumber,minBathroomsNumber,minBuiltArea,maxBuiltArea,condition,minPrivateArea,maxPrivateArea);
    }
}
