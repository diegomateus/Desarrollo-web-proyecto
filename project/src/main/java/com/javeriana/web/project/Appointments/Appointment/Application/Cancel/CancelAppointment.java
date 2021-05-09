package com.javeriana.web.project.Appointments.Appointment.Application.Cancel;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.Services.AppointmentDomainFinder;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class CancelAppointment {
    private AppointmentRepository repository;
    private AppointmentDomainFinder finder;

    public CancelAppointment(AppointmentRepository repository, AppointmentDomainFinder appointmentDomainFinder) {
        this.repository = repository;
        this.finder = appointmentDomainFinder;
    }

    public void execute(String appointmentId){
        Optional<Appointment> actualAppointment = finder.execute(appointmentId);
        Appointment appointment = actualAppointment.get();
        appointment.deleteAppointment(appointment);
        repository.delete(appointment);
    }
}
