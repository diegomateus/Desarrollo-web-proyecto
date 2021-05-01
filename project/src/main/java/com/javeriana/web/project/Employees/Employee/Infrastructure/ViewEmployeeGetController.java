package com.javeriana.web.project.Employees.Employee.Infrastructure;

import com.javeriana.web.project.Employees.Employee.Aplication.Find.EmployeeFinder;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.EmployeeNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/employees")
public class ViewEmployeeGetController {
    @Autowired
    private EmployeeFinder finder;

    @GetMapping(value = "/{employeeId}")
    public String execute(@PathVariable("employeeId") String id){
        Employee employee = finder.execute(id);
        return employee.email();
    }
    
}
