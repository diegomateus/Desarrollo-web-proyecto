package com.javeriana.web.project.Appointments.Appointment.Domain.Services;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Exceptions.NoAssignedAppointments;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class AssignedAppointmentsFinder {

    private AppointmentRepository repository;

    public AssignedAppointmentsFinder(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Optional<List<Appointment>> execute(String employeeId){
        Optional<List<Appointment>> appointments = repository.findAssignedAppointmets(employeeId);
        if(appointments.isEmpty()){
            throw new NoAssignedAppointments("El empleado con id " + employeeId + " no tiene citas asignadas");
        }
        return appointments;
    }
}
