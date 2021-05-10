package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Offer.Application.filterOffers.FilterOffers;
import com.javeriana.web.project.Properties.Property.Application.FilterProperties.FilterProperties;
import com.javeriana.web.project.Properties.Property.Application.FilterProperties.FilterPropertiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class FilterPropertiesController {

    @Autowired
    FilterProperties filterProperties;

    @Autowired
    FilterOffers filterOffers;

    @GetMapping (value = "/search/{propertyType}/{priceLowerLimit}/{priceUpperLimit}/{city}/{bedRoomsNumber}/{bathRoomNumber}/{action}/{propertyCondition}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap> execute(
                                           @PathVariable("propertyType") String propertyType,
                                           @PathVariable("priceLowerLimit") int priceLowerLimit,
                                           @PathVariable("priceUpperLimit") int priceUpperLimit,
                                           @PathVariable("city") String city,
                                           @PathVariable("bedRoomsNumber") int bedRoomsNumber,
                                           @PathVariable("bathRoomNumber") int bathRoomNumber,
                                           @PathVariable("action") String action,
                                           @PathVariable("propertyCondition") String propertyCondition
    ){
        List<String> propiedades = filterOffers.execute(priceLowerLimit,priceUpperLimit,action);
        FilterPropertiesResponse response = new FilterPropertiesResponse(filterProperties.execute(propiedades, propertyType,city,
                bedRoomsNumber,bathRoomNumber,propertyCondition));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
