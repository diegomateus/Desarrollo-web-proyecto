package com.javeriana.web.project.Employees.Employee.Application.Login;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.TokenGenerator;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Domain.Token;

public class EmployeeLogin {
    private TokenGenerator tokenGenerator;

    public EmployeeLogin(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }

    public Token execute(String email, String password) {
        //TODO: Validate username and password
        Employee employee = new Employee(
                new EmployeeId("c6a99a4b-51e6-4af7-a7d8-1a26516fd2f1"),
                new EmployeeEmail("employe@example.com"),
                new EmployeePassword("1234"),
                new EmployeeFirstName("John"),
                new EmployeeLastName("Doe"),
                new EmployeeIsAdministrator(false));
        return tokenGenerator.getToken(employee);
    }
}
