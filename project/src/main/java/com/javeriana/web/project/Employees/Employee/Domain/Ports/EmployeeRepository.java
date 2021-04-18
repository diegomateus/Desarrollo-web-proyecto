package com.javeriana.web.project.Employees.Employee.Domain.Ports;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;

public interface EmployeeRepository {
    void save(Employee employee);

    //TODO: Add other methods
}
