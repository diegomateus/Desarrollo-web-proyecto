package com.javeriana.web.project.Employees.Employee.Domain.Ports;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    void save(Employee employee);
    Optional<Employee> find (String employeeId);
    void update (String employeeId,Employee employee);
}
