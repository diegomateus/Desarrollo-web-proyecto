package com.javeriana.web.project.Appointments.Appointment.Domain.Ports;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;

import java.util.List;

public interface AppointmentRepository {

    void save(Appointment appointment);

    List<Appointment> getUnassignedAppointments();

}
