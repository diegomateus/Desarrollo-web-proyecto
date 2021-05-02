package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.PropertyConditionEnum;

public class Condition {
    private PropertyConditionEnum value;

    public Condition(PropertyConditionEnum value) {
        this.value = value;
    }

    public PropertyConditionEnum value() {
        return this.value;
    }
}
