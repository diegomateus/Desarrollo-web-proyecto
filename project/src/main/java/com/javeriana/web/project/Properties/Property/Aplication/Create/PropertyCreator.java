package com.javeriana.web.project.Properties.Property.Aplication.Create;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Domain.PropertyConditionEnum;
import com.javeriana.web.project.Shared.Domain.PropertyTypeEnum;
import java.util.Calendar;
import java.util.List;

public class PropertyCreator {
    private PropertyRepository repository;

    public PropertyCreator(PropertyRepository repository) {
        this.repository = repository;
    }

    public void execute(String propertyId, String address, PropertyTypeEnum propertyType, String city, String description, int bedroomsNumber, int bathroomsNumber, int privateArea, int builtArea, int serviceLevel, PropertyConditionEnum condition, Calendar deliveryDate, Long latitude, Long longitude, List<Image> images, List<SerializedQuestion> questions, List<SerializedOffer> offers){
        Property property = new Property(new PropertyId(propertyId),new Address(address),new PropertyType(propertyType),new City(city),new Description(description),new BedroomsNumber(bedroomsNumber),new BathroomsNumber(bathroomsNumber),new PrivateArea(privateArea),new BuiltArea(builtArea),new ServiceLevel(serviceLevel), new Condition(condition),new DeliveryDate(deliveryDate),new Location(latitude,longitude),images,questions,offers);
        repository.save(property);
    }
}
