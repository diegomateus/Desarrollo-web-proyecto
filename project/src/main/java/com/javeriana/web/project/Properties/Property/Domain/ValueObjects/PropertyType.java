package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.PropertyTypeEnum;

public class PropertyType {
    private PropertyTypeEnum value;

    PropertyType(PropertyTypeEnum value) {
        this.value = value;
    }

    public PropertyTypeEnum value(){
        return this.value;
    }
}
