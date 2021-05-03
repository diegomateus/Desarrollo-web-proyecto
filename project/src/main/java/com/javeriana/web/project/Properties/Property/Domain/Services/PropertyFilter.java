package com.javeriana.web.project.Properties.Property.Domain.Services;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.List;

public class PropertyFilter {

    private PropertyRepository repository;

    public PropertyFilter(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<Property> execute(BedroomsNumber minBedroomsNumber,
                                  BathroomsNumber minBathroomsNumber,
                                  BuiltArea minBuiltArea, BuiltArea maxBuiltArea,
                                  Condition condition,
                                  PrivateArea minPrivateArea, PrivateArea maxPrivateArea){
        List<Property> properties = repository.filter(minBedroomsNumber,minBathroomsNumber,minBuiltArea,maxBuiltArea,condition,minPrivateArea,maxPrivateArea);
        if(properties.isEmpty()){
            //TO DO
            //Crear throw de no hay
        }

        return properties;
    }
}
