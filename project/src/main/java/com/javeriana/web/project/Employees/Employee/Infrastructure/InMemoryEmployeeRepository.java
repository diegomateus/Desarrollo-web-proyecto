package com.javeriana.web.project.Employees.Employee.Infrastructure;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryEmployeeRepository implements EmployeeRepository {
    private Employee employee = new Employee(new EmployeeId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432723"),new EmployeeEmail("prueba@hotmail.com"),new EmployeePassword("Prueba1234&"),new EmployeeFirstName("Diego"),new EmployeeLastName("Mateus"),new EmployeeIsAdministrator(true));
    private Employee employee2 = new Employee(new EmployeeId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432724"),new EmployeeEmail("prueba@hotmail.com"),new EmployeePassword("Prueba1234&"),new EmployeeFirstName("Diego"),new EmployeeLastName("Mateus"),new EmployeeIsAdministrator(true));

    private List<Employee> employees = new ArrayList(){{
        add(employee);
        add(employee2);
    }};


    @Override
    public void save(Employee employee) {

    }

    @Override
    public Optional<Employee> find(String employeeId) {
        return employees.stream().filter(employee -> employee.equalsById(employeeId)).findFirst();
    }

    @Override
    public void update(String employeeId, Employee employee) {

    }
}
