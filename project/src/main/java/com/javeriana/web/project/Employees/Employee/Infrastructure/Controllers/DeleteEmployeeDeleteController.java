package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Employees.Employee.Application.DeleteEmployee.EmployeeDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class DeleteEmployeeDeleteController {

    @Autowired
    EmployeeDeleter employeeDeleter;

    @DeleteMapping(value = "{id}")
    public ResponseEntity execute(@PathVariable("id") String id) {
        employeeDeleter.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
