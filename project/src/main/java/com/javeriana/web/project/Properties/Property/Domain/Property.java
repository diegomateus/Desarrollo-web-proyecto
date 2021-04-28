package com.javeriana.web.project.Properties.Property.Domain;

import java.util.Objects;

public class Property {
    private String propertyId;
    private String address;
    private String propertyType;
    private String city;
    private String description;
    private String bedroomsNumber;
    private String bathroomsNumber;
    private String privateArea;
    private String builtArea;
    private String serviceLevel;
    private String condition;
    private String deliveryDate;
    private String Location;
    private String Images;
    private String questions;

    public Property(String propertyId, String address, String propertyType, String city, String description, String bedroomsNumber, String bathroomsNumber, String privateArea, String builtArea, String serviceLevel, String condition, String deliveryDate, String location, String images, String questions) {
        this.propertyId = propertyId;
        this.address = address;
        this.propertyType = propertyType;
        this.city = city;
        this.description = description;
        this.bedroomsNumber = bedroomsNumber;
        this.bathroomsNumber = bathroomsNumber;
        this.privateArea = privateArea;
        this.builtArea = builtArea;
        this.serviceLevel = serviceLevel;
        this.condition = condition;
        this.deliveryDate = deliveryDate;
        this.Location = location;
        this.Images = images;
        this.questions = questions;
    }

    public void updateProperty(String address, String propertyType, String city, String description, String bedroomsNumber, String bathroomsNumber, String privateArea, String builtArea, String serviceLevel, String condition, String deliveryDate, String location, String images, String questions){
        this.address = address;
        this.propertyType = propertyType;
        this.city = city;
        this.description = description;
        this.bedroomsNumber = bedroomsNumber;
        this.bathroomsNumber = bathroomsNumber;
        this.privateArea = privateArea;
        this.builtArea = builtArea;
        this.serviceLevel = serviceLevel;
        this.condition = condition;
        this.deliveryDate = deliveryDate;
        this.Location = location;
        this.Images = images;
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId) &&
                Objects.equals(address, property.address) &&
                Objects.equals(propertyType, property.propertyType) &&
                Objects.equals(city, property.city) &&
                Objects.equals(description, property.description) &&
                Objects.equals(bedroomsNumber, property.bedroomsNumber) &&
                Objects.equals(bathroomsNumber, property.bathroomsNumber) &&
                Objects.equals(privateArea, property.privateArea) &&
                Objects.equals(builtArea, property.builtArea) &&
                Objects.equals(serviceLevel, property.serviceLevel) &&
                Objects.equals(condition, property.condition) &&
                Objects.equals(deliveryDate, property.deliveryDate) &&
                Objects.equals(Location, property.Location) &&
                Objects.equals(Images, property.Images) &&
                Objects.equals(questions, property.questions);
    }

}
