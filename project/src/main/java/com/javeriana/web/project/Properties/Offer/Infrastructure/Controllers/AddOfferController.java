package com.javeriana.web.project.Properties.Offer.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Offer.Application.CreateOffer.OfferCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
public class AddOfferController {

    @Autowired
    private OfferCreator offerCreator;

    @GetMapping(value="/{propertyId}/offers")
    public ResponseEntity execute(@RequestBody Request request,@PathVariable("propertyId") String propertyId){
        offerCreator.execute(request.getOfferId(),propertyId,request.getPrice(),request.getAction());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}

class Request {

    private String offerId;
    private String propertyId;
    private int price;
    private String action;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}