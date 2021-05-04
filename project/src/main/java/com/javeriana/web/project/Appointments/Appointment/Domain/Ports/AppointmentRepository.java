package com.javeriana.web.project.Appointments.Appointment.Domain.Ports;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;

public interface AppointmentRepository {

    void save(Appointment appointment);

}
