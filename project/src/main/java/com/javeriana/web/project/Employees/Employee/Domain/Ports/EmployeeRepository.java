package com.javeriana.web.project.Employees.Employee.Domain.Ports;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    void save(Employee employee);

    public Optional<Employee> authenticate(String email, String password);

    public Optional<Employee> getByEmail(String email);
    //TODO: Add other methods
    Optional<Employee> find (String employeeId);
    
    void update (String employeeId,Employee employee);
}
