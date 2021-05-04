package com.javeriana.web.project.Properties.Offer.Application.CreateOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferAlreadyExist;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferNotExist;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.PropertyNotFound;
import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferDomainFinder;
import com.javeriana.web.project.Properties.Offer.Domain.Services.PropertyValidator;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinder;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

public class OfferCreator {

    private OfferRepository repository;
    private EventBus eventBus;
    private PropertyFinder propertyFinder;
    private PropertyValidator propertyValidator;
    private OfferDomainFinder offerDomainFinder;

    public OfferCreator(OfferRepository repository, EventBus eventBus, PropertyFinder propertyFinder) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.propertyFinder=propertyFinder;
        this.offerDomainFinder = new OfferDomainFinder(repository);
        this.propertyValidator=new PropertyValidator(propertyFinder);
    }

    public void execute(String offerId, String propertyId, int price, String action){
        validate(offerId,propertyId);
        Offer offer=new Offer(new OfferId(offerId),new PropertyId(propertyId), new Price(price),new Action(action));
        repository.save(offer);
        this.eventBus.publish(offer.pullDomainEvents());
    }

    private boolean validate(String offerId, String propertyId) {
        if(!offerDomainFinder.execute(offerId).isEmpty()){
            throw new OfferAlreadyExist("Offer with id "+offerId+"already exist");
        }
        try {
            if(propertyValidator.execute(propertyId)){
                return true;
            }
        }catch (PropertyNotFound e){

        }
        return false;
    }


}
