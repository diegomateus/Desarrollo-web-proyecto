package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PrivateArea;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrivateAreaTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new PrivateArea(1000));
    }

    @Test
    void should_throw_InvalidNumber_Negative() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new PrivateArea(-1));
        assertEquals("Invalid area number", exception.getMessage());
    }
    @Test
    void should_throw_InvalidNumber_Zero() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new PrivateArea(0));
        assertEquals("Invalid area number", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_21() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new PrivateArea(1000000001));
        assertEquals("Invalid area number", exception.getMessage());
    }
}
