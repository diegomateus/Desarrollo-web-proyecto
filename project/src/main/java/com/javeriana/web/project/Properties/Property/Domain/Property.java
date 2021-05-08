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
    private Latitude latitude;
    private Longitude longitude;
    private Optional<List<Image>> images;
    private Optional<List<SerializedQuestion>> serializedQuestions;
    private Optional<List<SerializedOffer>> serializedOffers;

    private Property() {
    }

    public Property(PropertyId propertyId, Address address, PropertyType propertyType,
                    City city, Description description, BedroomsNumber bedroomsNumber,
                    BathroomsNumber bathroomsNumber, PrivateArea privateArea, BuiltArea builtArea,
                    ServiceLevel serviceLevel, Condition condition, DeliveryDate deliveryDate,
                    Latitude latitude, Longitude longitude, List<Image> images,
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
        this.latitude = latitude;
        this.longitude = longitude;
        this.images = Optional.ofNullable(images);
        this.serializedQuestions = Optional.ofNullable(serializedQuestions);
        this.serializedOffers = Optional.ofNullable(serializedOffers);
    }
    
    public static Property create(PropertyId propertyId,
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
                                  Latitude latitude,
                                  Longitude longitude){
        return new Property(propertyId,address,propertyType,city,description,bedroomsNumber,bathroomsNumber,privateArea,builtArea,serviceLevel,condition,deliveryDate,latitude,longitude,null,null,null);
        
    }

    public void updateProperty(Address address, PropertyType propertyType,
                               City city, Description description, BedroomsNumber bedroomsNumber,
                               BathroomsNumber bathroomsNumber, PrivateArea privateArea, BuiltArea builtArea,
                               ServiceLevel serviceLevel, Condition condition, DeliveryDate deliveryDate,
                               Latitude latitude, Longitude longitude){
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
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public HashMap<String,String> data(){
        HashMap<String,String> data = new HashMap<String,String>(){{
            put("id",propertyId.value());
            put("address",address.value());
            put("type",propertyType.value());
            put("city",city.value());
            put("bedRooms",String.valueOf(bedroomsNumber.value()));
            put("badRooms",String.valueOf(bathroomsNumber.value()));
            put("privateArea",String.valueOf(privateArea.value()));
            put("builtArea",String.valueOf(builtArea.value()));
            put("serviceLevel",String.valueOf(serviceLevel.value()));
            put("condition",condition.value());
            put("deliveryDate",deliveryDate.value().toString());
            put("latitude",String.valueOf(latitude.value()));
            put("longitude",String.valueOf(longitude.value()));

        }};

        return data;
    }

    public boolean equalsById(String otherId){
        return this.propertyId.equals(new PropertyId(otherId));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId) && Objects.equals(address, property.address) && Objects.equals(propertyType, property.propertyType) && Objects.equals(city, property.city) && Objects.equals(description, property.description) && Objects.equals(bedroomsNumber, property.bedroomsNumber) && Objects.equals(bathroomsNumber, property.bathroomsNumber) && Objects.equals(privateArea, property.privateArea) && Objects.equals(builtArea, property.builtArea) && Objects.equals(serviceLevel, property.serviceLevel) && Objects.equals(condition, property.condition) && Objects.equals(deliveryDate, property.deliveryDate) && Objects.equals(latitude, property.latitude) && Objects.equals(longitude, property.longitude) && Objects.equals(images, property.images) && Objects.equals(serializedQuestions, property.serializedQuestions) && Objects.equals(serializedOffers, property.serializedOffers);
    }

    public Optional<List<HashMap<String,Object>>> getImages(){
        Optional<List<HashMap<String,Object>>> response = Optional.empty();
        if(this.images.isPresent()){
            response=Optional.of(this.images.get().stream().map(image->image.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addImage(String image){
        List<Image> imageList=this.images.isEmpty() ? new ArrayList<>():this.images.get();
        imageList.add(new Image(image,Integer.toString(imageList.size())));
        this.images=Optional.ofNullable(imageList);
    }

    public boolean deleteImage(String imageId){
        int index=Integer.valueOf(imageId);
        if(index>=this.images.get().size() || index<0){
            return false;
        }
        images.get().remove(index);
        return true;
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

    public void modifyOffer(SerializedOffer serializedOffer){
        List<SerializedOffer> offersList=this.serializedOffers.get();
        SerializedOffer serializedOfferActual=offersList.stream().
                filter(offer->offer.equalsSerializedOfferId(serializedOffer)).findFirst().get();
        offersList.remove(serializedOfferActual);
        offersList.add(serializedOffer);
        this.serializedOffers=Optional.ofNullable(offersList);
    }

    public void deleteOffer(String offerId) {
        List<SerializedOffer> offersList=this.serializedOffers.get();
        SerializedOffer serializedOfferActual=offersList.stream().
                filter(offer->offer.getOfferId().equals(offerId)).findFirst().get();
        offersList.remove(serializedOfferActual);
    }

    public PropertyId getPropertyId() {
        return propertyId;
    }

    public Address getAddress() {
        return address;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public City getCity() {
        return city;
    }

    public Description getDescription() {
        return description;
    }

    public BedroomsNumber getBedroomsNumber() {
        return bedroomsNumber;
    }

    public BathroomsNumber getBathroomsNumber() {
        return bathroomsNumber;
    }

    public PrivateArea getPrivateArea() {
        return privateArea;
    }

    public BuiltArea getBuiltArea() {
        return builtArea;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public Condition getCondition() {
        return condition;
    }

    public DeliveryDate getDeliveryDate() {
        return deliveryDate;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    public Longitude getLongitude() {
        return longitude;
    }
}
