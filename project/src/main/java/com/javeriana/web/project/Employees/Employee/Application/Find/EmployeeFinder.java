package com.javeriana.web.project.Employees.Employee.Application.Find;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.EmployeeDomainFinder;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeeId;

import java.util.Optional;

public class EmployeeFinder {
    private EmployeeDomainFinder finder;

    public EmployeeFinder(EmployeeRepository repository){
        this.finder = new EmployeeDomainFinder(repository);
    }

    public Employee execute (String employeeId){
        Optional<Employee> employee = finder.execute(new EmployeeId(employeeId).value());
        return employee.get();
    }
}
