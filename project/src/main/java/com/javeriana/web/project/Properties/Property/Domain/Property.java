package com.javeriana.web.project.Properties.Property.Domain;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import java.util.*;
import java.util.stream.Collectors;

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
    private Optional<List<Image>> images;
    private Optional<List<SerializedQuestion>> serializedQuestions;
    private Optional<List<SerializedOffer>> serializedOffers;

    public Property() {
    }

    public Property(PropertyId propertyId, Address address, PropertyType propertyType,
                    City city, Description description, BedroomsNumber bedroomsNumber,
                    BathroomsNumber bathroomsNumber, PrivateArea privateArea, BuiltArea builtArea,
                    ServiceLevel serviceLevel, Condition condition, DeliveryDate deliveryDate,
                    Location location, List<Image> images,
                    List<SerializedQuestion> serializedQuestions,
                    List<SerializedOffer> serializedOffers) {
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
        this.location = location;
        this.images = Optional.ofNullable(images);
        this.serializedQuestions = Optional.ofNullable(serializedQuestions);
        this.serializedOffers = Optional.ofNullable(serializedOffers);
    }

    public void updateProperty(Address address, PropertyType propertyType,
                               City city, Description description, BedroomsNumber bedroomsNumber,
                               BathroomsNumber bathroomsNumber, PrivateArea privateArea, BuiltArea builtArea,
                               ServiceLevel serviceLevel, Condition condition, DeliveryDate deliveryDate,
                               Location location, Optional<List<Image>> images,
                               Optional<List<SerializedQuestion>> serializedQuestions,
                               Optional<List<SerializedOffer>> serializedOffers){
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
        this.location = location;
        this.images = images;
        this.serializedQuestions = serializedQuestions;
        this.serializedOffers = serializedOffers;
    }

    public String address(){
        return this.address.value();
    }

    public boolean equalsById(String otherId){
        return this.propertyId.equals(new PropertyId(otherId));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId) && Objects.equals(address, property.address) && Objects.equals(propertyType, property.propertyType) && Objects.equals(city, property.city) && Objects.equals(description, property.description) && Objects.equals(bedroomsNumber, property.bedroomsNumber) && Objects.equals(bathroomsNumber, property.bathroomsNumber) && Objects.equals(privateArea, property.privateArea) && Objects.equals(builtArea, property.builtArea) && Objects.equals(serviceLevel, property.serviceLevel) && Objects.equals(condition, property.condition) && Objects.equals(deliveryDate, property.deliveryDate) && Objects.equals(location, property.location) && Objects.equals(images, property.images) && Objects.equals(serializedQuestions, property.serializedQuestions) && Objects.equals(serializedOffers, property.serializedOffers);
    }

    public Optional<List<HashMap<String,Object>>> getImages(){
        Optional<List<HashMap<String,Object>>> response = Optional.empty();
        if(this.images.isPresent()){
            response=Optional.of(this.images.get().stream().map(image->image.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addImage(Image image){
        List<Image> imageList=this.images.isEmpty() ? new ArrayList<>():this.images.get();
        imageList.add(image);
        this.images=Optional.ofNullable(imageList);
    }

    public Optional<List<HashMap<String,Object>>> getSerializedQuestions(){
        Optional<List<HashMap<String,Object>>> response = Optional.empty();
        if(this.serializedQuestions.isPresent()){
            response=Optional.of(this.serializedQuestions.get().stream().map(serializedQuestion->serializedQuestion.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addQuestion(SerializedQuestion question){
        List<SerializedQuestion> questionsList=this.serializedQuestions.isEmpty() ? new ArrayList<>():this.serializedQuestions.get();
        questionsList.add(question);
        this.serializedQuestions=Optional.ofNullable(questionsList);
    }

    public Optional<List<HashMap<String,Object>>> getSerializedOffers(){
        Optional<List<HashMap<String,Object>>> response = Optional.empty();
        if(this.serializedOffers.isPresent()){
            response=Optional.of(this.serializedOffers.get().stream().map(serializedOffer->serializedOffer.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addOffer(SerializedOffer offer){
        List<SerializedOffer> offersList=this.serializedOffers.isEmpty() ? new ArrayList<>():this.serializedOffers.get();
        offersList.add(offer);
        this.serializedOffers=Optional.ofNullable(offersList);
    }
}
