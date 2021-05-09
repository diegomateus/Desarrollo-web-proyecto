package com.javeriana.web.project.Appointments.Appointment.Application.FindAssigned;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.Services.AssignedAppointmentsFinder;

import java.util.List;

public class FindAssignedAppointments {

    private AppointmentRepository repository;
    private AssignedAppointmentsFinder finder;

    public FindAssignedAppointments(AppointmentRepository repository) {
        this.repository = repository;
        this.finder = new AssignedAppointmentsFinder(repository);
    }

    public List<Appointment> execute(String employeeId){
        return finder.execute(employeeId).get();
    }
}
