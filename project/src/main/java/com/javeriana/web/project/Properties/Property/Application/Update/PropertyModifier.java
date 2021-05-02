package com.javeriana.web.project.Properties.Property.Application.Update;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyConditionEnum;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyTypeEnum;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class PropertyModifier {

    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public PropertyModifier(PropertyRepository repository) {
        this.repository = repository;
        this.finder = new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId, String address, PropertyTypeEnum propertyType, String city, String description, int bedroomsNumber, int bathroomsNumber, int privateArea, int builtArea, int serviceLevel, PropertyConditionEnum condition, Calendar deliveryDate, Long latitude, Long longitude, Optional<List<Image>> images, Optional<List<SerializedQuestion>> questions, Optional<List<SerializedOffer>> offers){
        Optional<Property> actualProperty = finder.execute(propertyId);
        Property oldProperty = actualProperty.get();
        oldProperty.updateProperty(new Address(address), new PropertyType(propertyType), new City(city), new Description(description), new BedroomsNumber(bedroomsNumber), new BathroomsNumber(bathroomsNumber), new PrivateArea(privateArea), new BuiltArea(builtArea), new ServiceLevel(serviceLevel), new Condition(condition), new DeliveryDate(deliveryDate), new Location(latitude, longitude), images, questions, offers);
        repository.update(propertyId, oldProperty);
    }

}
