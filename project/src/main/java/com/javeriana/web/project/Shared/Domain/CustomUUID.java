package com.javeriana.web.project.Shared.Domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomUUID extends StringValueObject {

    public CustomUUID(String value) {
        super(value);
        this.validate(value);
    }

    private void validate(String value) {
        this.validateUUIDFormatRule(value);
    }

    private void validateUUIDFormatRule(String value) {
        try {
            UUID.fromString(value);
        }
        catch (Exception e){
            throw new InvalidUUID("Invalid UUID");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUUID that = (CustomUUID) o;
        return Objects.equals(value, that.value);
    }
}
