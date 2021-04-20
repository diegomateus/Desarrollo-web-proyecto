package com.javeriana.web.project.Properties.Property.Domain;

import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;

public class Property {
    private PropertyId propertyId;
    private Address address;
    private PropertyType propertyType;
    private City city;
    private Description description;
    private BedroomsNumber bedroomsNumber;
    private BathroomsNumber bathroomsNumber;
    private PrivateArea privateArea;
    private BuiltArea builtArea;
    private ServiceLevel serviceLevel;
    private Condition condition;
    private DeliveryDate deliveryDate;
    private Location location;
    private Images images;
    private SerializedQuestions serializedQuestions;
    private SerializedOffers serializedOffers;

    public Property(PropertyId propertyId,
                    Address address,
                    PropertyType propertyType,
                    City city,
                    Description description,
                    BedroomsNumber bedroomsNumber,
                    BathroomsNumber bathroomsNumber,
                    PrivateArea privateArea,
                    BuiltArea builtArea,
                    ServiceLevel serviceLevel,
                    Condition condition,
                    DeliveryDate deliveryDate,
                    Location location,
                    Images images,
                    SerializedQuestions serializedQuestions,
                    SerializedOffers serializedOffers)
    {
        this.propertyId = propertyId;
        this.address = address;
        this.propertyType = propertyType;
        this.city = city;
        this.description = description;
        this.bedroomsNumber = bedroomsNumber;
        this.bathroomsNumber=bathroomsNumber;
        this.privateArea = privateArea;
        this.builtArea = builtArea;
        this.serviceLevel = serviceLevel;
        this.condition = condition;
        this.deliveryDate = deliveryDate;
        this.location = location;
        this.images = images;
        this.serializedQuestions = serializedQuestions;
        this.serializedOffers = serializedOffers;
    }
}
