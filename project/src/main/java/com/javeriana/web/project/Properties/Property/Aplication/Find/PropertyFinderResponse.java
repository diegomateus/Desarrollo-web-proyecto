package com.javeriana.web.project.Properties.Property.Aplication.Find;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Shared.Application.Response;

import java.util.HashMap;

public class PropertyFinderResponse implements Response{

    private Property property;

    public PropertyFinderResponse(Property property){
        this.property = property;
    }

    public HashMap response(){
        HashMap response = this.property.data();
        response.remove("id");
        return response;
    }
}
