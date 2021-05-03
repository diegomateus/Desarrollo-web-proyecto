package com.javeriana.web.project.Properties.Property.Infrastructure;

import com.javeriana.web.project.Properties.Property.Application.Create.PropertyCreator;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyAlreadyExist;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.Image;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedOffer;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedQuestion;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyConditionEnum;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyTypeEnum;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/properties")
public final class CreatePropertyPostController {

    @Autowired
    private PropertyCreator creator;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        creator.execute(request.getPropertyId(), request.getAddress(), request.getPropertyType(),request.getCity(),request.getDescription(),request.getBedroomsNumber(),request.getBathroomsNumber(),request.getPrivateArea(),request.getBuiltArea(),request.getServiceLevel(),request.getCondition(),request.getDeliveryDate(),request.getLatitude(),request.getLongitude(),request.getImages(),request.getQuestions(),request.getOffers());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(PropertyAlreadyExist.class)
    public ResponseEntity<HashMap> handlePropertyAlreadyExist(PropertyAlreadyExist exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    //TODO:AGREGAR LOS ERRORES


}

class Request {

    private String propertyId;
    private String address;
    private PropertyTypeEnum propertyType;
    private String city;
    private String description;
    private int bedroomsNumber;
    private int bathroomsNumber;
    private int privateArea;
    private int builtArea;
    private int serviceLevel;
    private PropertyConditionEnum condition;
    private LocalDate deliveryDate;
    private Long latitude;
    private Long longitude;
    private List<Image> images;
    private List<SerializedQuestion> questions;
    private List<SerializedOffer> offers;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertyTypeEnum getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyTypeEnum propertyType) {
        this.propertyType = propertyType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBedroomsNumber() {
        return bedroomsNumber;
    }

    public void setBedroomsNumber(int bedroomsNumber) {
        this.bedroomsNumber = bedroomsNumber;
    }

    public int getBathroomsNumber() {
        return bathroomsNumber;
    }

    public void setBathroomsNumber(int bathroomsNumber) {
        this.bathroomsNumber = bathroomsNumber;
    }

    public int getPrivateArea() {
        return privateArea;
    }

    public void setPrivateArea(int privateArea) {
        this.privateArea = privateArea;
    }

    public int getBuiltArea() {
        return builtArea;
    }

    public void setBuiltArea(int builtArea) {
        this.builtArea = builtArea;
    }

    public int getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(int serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public PropertyConditionEnum getCondition() {
        return condition;
    }

    public void setCondition(PropertyConditionEnum condition) {
        this.condition = condition;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<SerializedQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SerializedQuestion> questions) {
        this.questions = questions;
    }

    public List<SerializedOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<SerializedOffer> offers) {
        this.offers = offers;
    }

}
