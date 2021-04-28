package com.javeriana.web.project.PropertiesTest.PropertyTests;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.DeliveryDate;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryDateTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new DeliveryDate(Calendar.getInstance()));
    }

    @Test
    void should_throw_InvalidNumber() {
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        Throwable exception = assertThrows(InvalidNumber.class, () -> new DeliveryDate(calendar));
        assertEquals("Invalid date", exception.getMessage());
    }
}
