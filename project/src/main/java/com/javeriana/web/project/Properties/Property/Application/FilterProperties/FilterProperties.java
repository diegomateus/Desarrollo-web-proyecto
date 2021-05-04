package com.javeriana.web.project.Properties.Property.Application.FilterProperties;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyFilter;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
<<<<<<< Updated upstream
import com.javeriana.web.project.Questions.Question.Domain.Question;
import org.springframework.stereotype.Component;
=======
import org.springframework.stereotype.Component;

>>>>>>> Stashed changes

import java.util.List;

@Component
public class FilterProperties {

    private PropertyRepository repository;
    private PropertyFilter propertiesFilter;

    public FilterProperties(PropertyRepository repository) {
        this.repository = repository;
        this.propertiesFilter = new PropertyFilter(repository);
    }

    public List<Property> execute(String propertyType, int priceLowerLimit, int priceUpperLimit, String city,
                                  int bedRoomsNumber, int bathRoomNumber, String action, String propertyCondition
                                  ){
        return propertiesFilter.execute(propertyType,priceLowerLimit,priceUpperLimit,city,
                bedRoomsNumber,bathRoomNumber,action,propertyCondition
        );
    }
}
