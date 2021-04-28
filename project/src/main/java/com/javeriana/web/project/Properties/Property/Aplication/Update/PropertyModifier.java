package com.javeriana.web.project.Properties.Property.Aplication.Update;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.PropertyNotExist;
import java.util.Optional;

public class PropertyModifier {

    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public PropertyModifier(PropertyRepository repository) {
        this.repository = repository;
        this.finder = new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId, String address, String propertyType, String city, String description, String bedroomsNumber, String bathroomsNumber, String privateArea, String builtArea, String serviceLevel, String condition, String deliveryDate, String location, String images, String questions){
        Optional<Property> actualProperty = finder.execute(propertyId);
        Property oldProperty = actualProperty.get();
        oldProperty.updateProperty(address, propertyType, city, description, bedroomsNumber, bathroomsNumber, privateArea, builtArea, serviceLevel, condition, deliveryDate, location, images, questions);
        repository.update(propertyId, oldProperty);
    }

}
