package com.javeriana.web.project.Employees.Employee.Application.DeleteEmployee;

import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;

public class EmployeeDeleter {

    private EmployeeRepository employeeRepository;

    public EmployeeDeleter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void execute(String id) {
        //TODO: Implement method
    }
}
