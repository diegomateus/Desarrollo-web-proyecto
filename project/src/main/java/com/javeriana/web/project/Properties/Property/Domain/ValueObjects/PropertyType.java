package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.Properties.PropertyTypeEnum;

public class PropertyType {
    private PropertyTypeEnum value;

    public PropertyType(PropertyTypeEnum value) {
        this.value = value;
    }

    public PropertyTypeEnum value(){
        return this.value;
    }
}
