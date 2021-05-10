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
        //Se filtran las ofertas
        List<String> propiedades = filterOffers.execute(priceLowerLimit,priceUpperLimit,action);
        //Se filtran las propiedades obtenidas de filtrar por ofertas
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
