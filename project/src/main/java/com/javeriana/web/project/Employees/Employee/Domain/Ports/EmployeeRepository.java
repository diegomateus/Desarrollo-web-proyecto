package com.javeriana.web.project.Employees.Employee.Domain.Ports;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;

public interface EmployeeRepository {
    void save(Employee employee);

    public boolean authenticate(String email, String password);

    //TODO: Add other methods
}
