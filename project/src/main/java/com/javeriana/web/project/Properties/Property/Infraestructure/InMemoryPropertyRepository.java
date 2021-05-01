package com.javeriana.web.project.Properties.Property.Infraestructure;


import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Domain.PropertyConditionEnum;
import com.javeriana.web.project.Shared.Domain.PropertyTypeEnum;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class InMemoryPropertyRepository implements PropertyRepository {

    private Property property = new Property(new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),new Address("calle 100"),new PropertyType(PropertyTypeEnum.APARTAMENTO),new City("bogota"),new Description("es grande"),new BedroomsNumber(3),new BathroomsNumber(2),new PrivateArea(1000),new BuiltArea(100),new ServiceLevel(3), new Condition(PropertyConditionEnum.NUEVO),new DeliveryDate(new GregorianCalendar(2021,5,11)),new Location((long)1.12345678,(long)1.12345678),null,null,null);
    private Property property2 = new Property(new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432722"),new Address("calle 105"),new PropertyType(PropertyTypeEnum.APARTAMENTO),new City("Medellin"),new Description("es grande"),new BedroomsNumber(3),new BathroomsNumber(2),new PrivateArea(1000),new BuiltArea(100),new ServiceLevel(3), new Condition(PropertyConditionEnum.NUEVO),new DeliveryDate(new GregorianCalendar(2021,5,11)),new Location((long)1.12345678,(long)1.12345678),null,null,null);

    private List<Property> properties = new ArrayList(){{
        add(property);
        add(property2);
    }};
    @Override
    public void save(Property property) {

    }

    @Override
    public Optional<Property> find(String propertyId) {
        return properties.stream().filter(property -> property.equalsById(propertyId)).findFirst();
    }

    @Override
    public void update(String propertyId, Property property) {

    }
}
