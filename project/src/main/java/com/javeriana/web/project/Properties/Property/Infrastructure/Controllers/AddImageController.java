package com.javeriana.web.project.Properties.Property.Infrastructure.Controllers;


import com.javeriana.web.project.Properties.Property.Application.AddImage.ImageAdditionner;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/properties")
public class AddImageController {

    @Autowired
    private ImageAdditionner imageAdditionner;

    @PostMapping(value = "/{propertyId}/images")
    public ResponseEntity execute(@RequestBody AddImageRequest request,@PathVariable("propertyId") String propertyId){
        imageAdditionner.execute(propertyId,request.getImageId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(PropertyNotExist.class)
    public ResponseEntity<HashMap> handlerPropertyNotExist(PropertyNotExist exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

class AddImageRequest {
    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
