package com.javeriana.web.project.Properties.Property.Domain.Services;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.ArrayList;
import java.util.List;

public class PropertyFilter {

    private PropertyRepository repository;

    public PropertyFilter(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<Property> execute(ArrayList<String> idPropiedades,
                                  BedroomsNumber minBedroomsNumber,
                                  BathroomsNumber minBathroomsNumber,
                                  Condition condition,
                                  PropertyType type){
        List<Property> properties = repository.filter(idPropiedades,minBedroomsNumber,minBathroomsNumber,condition,type);
        if(properties.isEmpty()){
            //TO DO
            //Crear throw de no hay
        }

        return properties;
    }
}
