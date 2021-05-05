package com.javeriana.web.project.Properties.Offer.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Offer.Application.UpdateOffer.OfferModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
public class EditOfferController {

    @Autowired
    private OfferModifier offerModifier;

    @PutMapping(value="/{propertyId}/offers/{offerId}")
    public ResponseEntity execute(@RequestBody Request request, @PathVariable("propertyId") String propertyId,@PathVariable("offerId") String offerId){
        offerModifier.execute(offerId,request.getPrice(),propertyId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
