package com.javeriana.web.project.Properties.Offer.Infrastructure.Controllers;


import com.javeriana.web.project.Properties.Offer.Application.DeleteOffer.OfferDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
public class DeleteOfferController {

    @Autowired
    private OfferDeleter offerDeleter;

    @DeleteMapping(value="/{propertyId}/offers/{offerId}")
    public ResponseEntity execute(@PathVariable("offerId") String offerId, @PathVariable("propertyId") String propertyId){
        offerDeleter.execute(offerId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
