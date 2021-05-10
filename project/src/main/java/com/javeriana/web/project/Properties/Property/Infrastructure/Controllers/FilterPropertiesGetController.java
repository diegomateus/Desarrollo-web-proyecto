package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;

import com.javeriana.web.project.Properties.Offer.Application.filterOffers.FilterOffers;
import com.javeriana.web.project.Properties.Property.Application.FilterProperties.FilterProperties;
import com.javeriana.web.project.Properties.Property.Application.FilterProperties.FilterPropertiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class FilterPropertiesGetController {

    @Autowired
    FilterProperties filterProperties;

    @Autowired
    FilterOffers filterOffers;

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap> execute(
                                           @RequestParam String propertyType,
                                           @RequestParam int priceLowerLimit,
                                           @RequestParam  int priceUpperLimit,
                                           @RequestParam  String city,
                                           @RequestParam  int bedRoomsNumber,
                                           @RequestParam  int bathRoomNumber,
                                           @RequestParam  String action,
                                           @RequestParam  String propertyCondition
    ){
        List<String> propiedades = filterOffers.execute(priceLowerLimit,priceUpperLimit,action);
        FilterPropertiesResponse response = new FilterPropertiesResponse(filterProperties.execute(propiedades, propertyType,city,
                bedRoomsNumber,bathRoomNumber,propertyCondition));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap> handleException(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
