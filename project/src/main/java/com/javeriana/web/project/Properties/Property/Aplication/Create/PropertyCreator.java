package com.javeriana.web.project.Properties.Property.Aplication.Create;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;

public class PropertyCreator {
    private PropertyRepository repository;

    public PropertyCreator(PropertyRepository repository) {
        this.repository = repository;
    }

    public void execute(String propertyId, String address, String propertyType, String city, String description, String bedroomsNumber, String bathroomsNumber, String privateArea, String builtArea, String serviceLevel, String condition, String deliveryDate, String location, String images, String questions){
        Property property = new Property(propertyId,address,propertyType,city,description,bedroomsNumber,bathroomsNumber,privateArea,builtArea,serviceLevel,condition,deliveryDate,location,images,questions);
        repository.save(property);
    }
}
