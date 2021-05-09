package com.javeriana.web.project.Properties.Property.Infrastructure;

import com.javeriana.web.project.Properties.Property.Application.Delete.PropertyDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public final class DeletePropertyDeleteController {

    @Autowired
    private PropertyDeleter deleter;

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{propertyId}")
    public ResponseEntity execute(@PathVariable("propertyId") String id){
        deleter.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
