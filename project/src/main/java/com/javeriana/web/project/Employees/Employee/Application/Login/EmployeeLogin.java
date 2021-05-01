package com.javeriana.web.project.Employees.Employee.Application.Login;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.TokenGenerator;
import com.javeriana.web.project.Shared.Domain.Token;

import java.util.Optional;

public class EmployeeLogin {
    private TokenGenerator tokenGenerator;
    private EmployeeRepository employeeRepository;

    public EmployeeLogin(TokenGenerator tokenGenerator, EmployeeRepository employeeRepository) {
        this.tokenGenerator = tokenGenerator;
        this.employeeRepository = employeeRepository;
    }

    public Optional<Token> execute(String email, String password) {
        Optional<Employee> employee = employeeRepository.authenticate(email, password);
        if (employee.isPresent()) {
            return Optional.of(tokenGenerator.getToken(employee.get()));
        }
        return Optional.ofNullable(null);
    }
}
