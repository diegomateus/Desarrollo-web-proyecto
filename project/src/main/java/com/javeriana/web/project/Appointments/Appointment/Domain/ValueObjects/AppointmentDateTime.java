package com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects;

import com.javeriana.web.project.Shared.DateTimeValueObject;
import com.javeriana.web.project.Shared.Domain.PastDateException;

import java.time.LocalDateTime;

public class AppointmentDateTime extends DateTimeValueObject {

    public AppointmentDateTime(LocalDateTime value) {
        super(value);
        this.validate(value);
    }

    private void validate(LocalDateTime value) {

    }

    private void precedenceRule(LocalDateTime value) {
        if (value.isBefore(LocalDateTime.now())){
            throw new PastDateException("The date chosen has already passed");
        }
    }

}
