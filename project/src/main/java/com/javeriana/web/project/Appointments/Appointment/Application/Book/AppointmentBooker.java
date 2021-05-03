package com.javeriana.web.project.Appointments.Appointment.Application.Book;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.*;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Shared.Domain.CustomUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentBooker {

    private AppointmentRepository repository;

    public AppointmentBooker(AppointmentRepository repository) {
        this.repository = repository;
    }

    public void execute(String propertyId,
                        int year,
                        int month,
                        int day,
                        int hour,
                        int minute,
                        String customerFirstName,
                        String customerLastName,
                        String customerEmail,
                        String customerPhoneNumber) {
        //Is it correct to use directly a class form a different bounded context?
        Property property = propertyFinder.get(propertyId);
        repository.save(new Appointment(
                new AppointmentId(UUID.randomUUID().toString()),
                new AppointmentProperty(
                        property.getPropertyId().value(),
                        property.getAddress().value(),
                        property.getPropertyType().value().toString(),
                        property.getCity().value(),
                        property.getLocation().latitude(),
                        property.getLocation().longitude()),
                new AppointmentDateTime(LocalDateTime.of(year, month, day, hour, minute)),
                new AppointmentCustomerFirstName(customerFirstName),
                new AppointmentCustomerLastName(customerLastName),
                new AppointmentCustomerEmail(customerEmail),
                new AppointmentCustomerPhoneNumber(customerPhoneNumber)));
    }

}
