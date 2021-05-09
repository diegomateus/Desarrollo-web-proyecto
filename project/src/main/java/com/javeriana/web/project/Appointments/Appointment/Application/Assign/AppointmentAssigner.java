package com.javeriana.web.project.Appointments.Appointment.Application.Assign;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.Services.AppointmentDomainFinder;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AssignedEmployee;
import org.springframework.stereotype.Component;

import java.util.Optional;


public class AppointmentAssigner {

    private AppointmentRepository repository;
    private AppointmentDomainFinder finder;

    public AppointmentAssigner(AppointmentRepository repository) {
        this.repository = repository;
        this.finder = new AppointmentDomainFinder(repository);
    }

    public void execute(String appointmentId, String employeeId, String email, String firstName, String lastName){
        Optional<Appointment> actualAppointment = finder.execute(appointmentId);
        Appointment appointment = actualAppointment.get();
        appointment.assignEmployee(employeeId,email,firstName,lastName);
        repository.assignEmployee(appointmentId,appointment);
    }
}
