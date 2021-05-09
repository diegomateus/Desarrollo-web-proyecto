package com.javeriana.web.project.Appointments.Appointment.Domain.Services;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentId;

import java.util.Optional;

public class AppointmentDomainFinder {
    AppointmentRepository repository;

    public AppointmentDomainFinder(AppointmentRepository repository) {
        this.repository = repository;
    }

        public Optional<Appointment> execute(String appointmentId){
        Optional<Appointment> appointment = repository.find(appointmentId);
        if(appointment.isEmpty()){
            //throw appointemt not exist
        }
        return  appointment;
    }
}
