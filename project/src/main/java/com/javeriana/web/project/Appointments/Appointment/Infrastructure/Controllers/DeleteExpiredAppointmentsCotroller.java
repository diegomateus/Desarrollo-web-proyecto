package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Controllers;

import com.javeriana.web.project.Appointments.Appointment.Application.DeleteExpiredAppointments.ExpiredAppointmentsDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class DeleteExpiredAppointmentsCotroller {

    @Autowired
    private ExpiredAppointmentsDeleter expiredAppointmentsDeleter;

    @PostMapping(value = "/expired")
    public ResponseEntity<List<HashMap>> execute() {
        expiredAppointmentsDeleter.execute();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
