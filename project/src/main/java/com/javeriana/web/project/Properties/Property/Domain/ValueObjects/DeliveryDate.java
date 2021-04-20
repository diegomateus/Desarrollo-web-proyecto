package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.CalendarValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

import java.time.LocalDate;
import java.util.Calendar;

public class DeliveryDate extends CalendarValueObject {

    public DeliveryDate(Calendar value) {
        super(value);
        this.validate(value);
    }

    private void validate(Calendar value) {
        this.numberRule(value);
    }

    private void numberRule(Calendar value) {
        if(value.before(LocalDate.now())) {
            throw new InvalidNumber("Invalid date");
        }
    }
}
