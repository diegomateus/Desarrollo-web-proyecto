package com.javeriana.web.project.Appointments.Appointment.Domain.Ports;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository {

    void save(Appointment appointment);
    Optional<Appointment> find(String appointmentId);
    Appointment assignEmployee(String appointmentId, Appointment appointment);
    Optional<List<Appointment>> findAssignedAppointmets(String employeeId);
    Optional<List<Appointment>> all();
}
