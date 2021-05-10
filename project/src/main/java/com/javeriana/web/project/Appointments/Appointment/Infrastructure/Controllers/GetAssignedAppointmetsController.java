package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Controllers;

import com.javeriana.web.project.Appointments.Appointment.Application.FindAssigned.FindAssignedAppointments;
import com.javeriana.web.project.Appointments.Appointment.Application.FindAssigned.FindAssignedAppointmetsResponse;
import com.javeriana.web.project.Appointments.Appointment.Application.Unassigned.UnassignedAppointmentsResponse;
import com.javeriana.web.project.Employees.Employee.Application.Find.EmployeeFinder;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/appointments")
public class GetAssignedAppointmetsController {

    @Autowired
    FindAssignedAppointments findAssignedAppointments;

    @Autowired
    EmployeeFinder employeeFinder;

    @GetMapping(value = "/assigned")
    public ResponseEntity<List<HashMap>> execute() {
        String employeeId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Employee assignedEmploye = employeeFinder.execute(employeeId);
        HashMap<String,String> datosEmpleado = assignedEmploye.data();
        FindAssignedAppointmetsResponse response = new FindAssignedAppointmetsResponse(findAssignedAppointments.execute(datosEmpleado.get("id")));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
