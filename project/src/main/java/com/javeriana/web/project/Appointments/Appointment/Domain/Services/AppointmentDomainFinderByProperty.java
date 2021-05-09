package com.javeriana.web.project.Appointments.Appointment.Domain.Services;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import java.util.List;
import java.util.Optional;

public class AppointmentDomainFinderByProperty {
    AppointmentRepository repository;

    public AppointmentDomainFinderByProperty(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> execute(String propertyId){
        List<Appointment> appointment = repository.findByProperty(propertyId).get();
        return  appointment;
    }
}
