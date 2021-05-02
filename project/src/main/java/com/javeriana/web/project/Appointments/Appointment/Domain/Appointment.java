package com.javeriana.web.project.Appointments.Appointment.Domain;

import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.*;

import java.util.Optional;

public class Appointment {
    private AppointmentId appointmentId;
    private AppointmentProperty appointmentProperty;
    private AppointmentDateTime appointmentDateTime;//TODO
    private Optional<AssignedEmployee> assignedEmployee;
    private AppointmentCustomerFirstName appointmentCustomerFirstName;
    private AppointmentCustomerLastName appointmentCustomerLastName;
    private AppointmentCustomerEmail appointmentCustomerEmail;
    private AppointmentCustomerPhoneNumber appointmentCustomerPhoneNumber;
}
