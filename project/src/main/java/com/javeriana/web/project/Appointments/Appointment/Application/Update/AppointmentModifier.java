package com.javeriana.web.project.Appointments.Appointment.Application.Update;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.Services.AppointmentDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;

import java.util.Optional;

public class AppointmentModifier {
    private AppointmentRepository repository;
    private AppointmentDomainFinder finder;

    public AppointmentModifier(AppointmentRepository repository){
        this.repository = repository;
        this.finder = new AppointmentDomainFinder(repository);
    }

    public void execute(String propertyId, String address, String propertyType, String city, long latitude, long longitude){
        Optional<Appointment> actualAppointment = finder.execute(propertyId);
        Appointment oldAppointment = actualAppointment.get();
        oldAppointment.updateProperty(new PropertyId(propertyId),new Address(address),new PropertyType(propertyType),new City(city), new Latitude(latitude),new Longitude(longitude));
        this.repository.updateProperty();
    }
}
