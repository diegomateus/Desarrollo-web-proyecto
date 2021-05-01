package com.javeriana.web.project.Properties.Property.Infraestructure;

import com.javeriana.web.project.Properties.Property.Aplication.Find.PropertyFinder;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/properties")
public class ViewPropertyGetController {

    @Autowired
    private PropertyFinder finder;

    @GetMapping(value="/{propertyId}")
    public String execute(@PathVariable("propertyId") String id){
        Property property = finder.execute(id);
        return property.address();
    }
}
