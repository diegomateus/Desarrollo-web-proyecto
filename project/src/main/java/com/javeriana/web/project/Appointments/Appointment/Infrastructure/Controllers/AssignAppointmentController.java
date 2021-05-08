package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Controllers;

import com.javeriana.web.project.Appointments.Appointment.Application.Assign.AppointmentAssigner;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Properties.Shared.Application.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/appointments")
public class AssignAppointmentController {

    @Autowired
    AppointmentAssigner assigner;

    @PutMapping(value = "/{appointmentId}")
    public ResponseEntity execute(@PathVariable("appointmentId") String id){
        Employee empleado = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HashMap<String,String> datosEmpleado = empleado.data();
        assigner.execute(id,datosEmpleado.get("id"),datosEmpleado.get("email"),
                datosEmpleado.get("name"),datosEmpleado.get("lastName"));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
