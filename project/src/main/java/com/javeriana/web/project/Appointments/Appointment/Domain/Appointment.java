package com.javeriana.web.project.Appointments.Appointment.Domain;

import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class Appointment {
    private AppointmentId appointmentId;
    private AppointmentProperty appointmentProperty;
    private AppointmentDateTime appointmentDateTime;
    private Optional<AssignedEmployee> assignedEmployee;
    private AppointmentCustomerFirstName appointmentCustomerFirstName;
    private AppointmentCustomerLastName appointmentCustomerLastName;
    private AppointmentCustomerEmail appointmentCustomerEmail;
    private AppointmentCustomerPhoneNumber appointmentCustomerPhoneNumber;

    public Appointment(AppointmentId appointmentId,
                       AppointmentProperty appointmentProperty,
                       AppointmentDateTime appointmentDateTime,
                       Optional<AssignedEmployee> assignedEmployee,
                       AppointmentCustomerFirstName appointmentCustomerFirstName,
                       AppointmentCustomerLastName appointmentCustomerLastName,
                       AppointmentCustomerEmail appointmentCustomerEmail,
                       AppointmentCustomerPhoneNumber appointmentCustomerPhoneNumber) {
        this.appointmentId = appointmentId;
        this.appointmentProperty = appointmentProperty;
        this.appointmentDateTime = appointmentDateTime;
        this.assignedEmployee = assignedEmployee;
        this.appointmentCustomerFirstName = appointmentCustomerFirstName;
        this.appointmentCustomerLastName = appointmentCustomerLastName;
        this.appointmentCustomerEmail = appointmentCustomerEmail;
        this.appointmentCustomerPhoneNumber = appointmentCustomerPhoneNumber;
    }

    public Appointment() {
    }

    public HashMap<String, String> data() {
        HashMap<String,String> data = new HashMap<String,String>(){{
            put("id", appointmentId.value());
            put("dateTime", appointmentDateTime.value().toString());
            put("customerFirstName", appointmentCustomerFirstName.value());
            put("customerLastName", appointmentCustomerLastName.value());
            put("customerEmail", appointmentCustomerEmail.value());
            put("customerPhoneNumber", appointmentCustomerPhoneNumber.value());
        }};
        return data;
    }

    public HashMap<String, Object> getAppointmentProperty() {
        return appointmentProperty.data();
    }

    public Optional<HashMap<String, Object>> getAssignedEmployee() {
        HashMap<String, Object> response = (assignedEmployee.isPresent()) ? assignedEmployee.get().data() : null;
        return Optional.ofNullable(response);
    }

    public void setAssignedEmployee(AssignedEmployee assignedEmployee) {
        this.assignedEmployee = Optional.ofNullable(assignedEmployee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId) && Objects.equals(appointmentProperty, that.appointmentProperty) && Objects.equals(appointmentDateTime, that.appointmentDateTime) && Objects.equals(assignedEmployee, that.assignedEmployee) && Objects.equals(appointmentCustomerFirstName, that.appointmentCustomerFirstName) && Objects.equals(appointmentCustomerLastName, that.appointmentCustomerLastName) && Objects.equals(appointmentCustomerEmail, that.appointmentCustomerEmail) && Objects.equals(appointmentCustomerPhoneNumber, that.appointmentCustomerPhoneNumber);
    }

    public void assignEmployee(String employeeId, String email, String firstName, String lastName){
        this.assignedEmployee = Optional.ofNullable(new AssignedEmployee(employeeId,email,firstName,lastName));
    }

    public void deleteAppointment(Appointment appointment) {
    }
}
