package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/appointments")
public class ViewUnassignedAppointmentsGetController {



    @GetMapping (value = "/unassigned")
    public ResponseEntity<HashMap> execute() {
    }

}
