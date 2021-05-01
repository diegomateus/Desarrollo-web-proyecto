package com.javeriana.web.project.Employees.Employee.Aplication.Create;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;

public class EmployeeCreator {
    private EmployeeRepository repository;

    public EmployeeCreator(EmployeeRepository repository){
        this.repository = repository;
    }

    public void execute(String employeeId,String employeeEmail,String employeePassword,String employeeFirstName,String employeeLastName,Boolean employeeIsAdministrator){
        Employee employee = new Employee(new EmployeeId(employeeId),new EmployeeEmail(employeeEmail), new EmployeePassword(employeePassword),new EmployeeFirstName(employeeFirstName),new EmployeeLastName(employeeLastName),new EmployeeIsAdministrator(employeeIsAdministrator));
        repository.save(employee);
    }
}
