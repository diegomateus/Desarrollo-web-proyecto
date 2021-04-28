package com.javeriana.web.project.PropertiesTest.PropertyTests;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PropertyType;
import com.javeriana.web.project.Shared.Domain.PropertyTypeEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class PropertyTypeTest {
    @Test
    void should_not_throw_exceptions_APARTAMENTO() {
        assertAll(() -> new PropertyType(PropertyTypeEnum.APARTAMENTO));
    }

    @Test
    void should_not_throw_exceptions_CASA() {
        assertAll(() -> new PropertyType(PropertyTypeEnum.CASA));
    }
}
