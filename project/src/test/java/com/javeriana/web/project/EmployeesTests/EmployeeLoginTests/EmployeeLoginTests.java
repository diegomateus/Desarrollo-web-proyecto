package com.javeriana.web.project.EmployeesTests.EmployeeLoginTests;

import com.javeriana.web.project.Employees.Employee.Application.Login.EmployeeLogin;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;
import com.javeriana.web.project.Employees.Employee.Infrastructure.Security.JWTTokenGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class EmployeeLoginTests {
    @Test
    void should_return_token() {
        EmployeeRepository repository = mock(EmployeeRepository.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        Employee employee = new Employee(
                new EmployeeId("c6575120-a952-4bff-b999-a7e1827f8bb7"),
                new EmployeeEmail("test@example.com"),
                new EmployeePassword(encoder.encode("1234")),
                new EmployeeFirstName("John"),
                new EmployeeLastName("Doe"),
                new EmployeeIsAdministrator(false));
        Mockito.when(repository.authenticate("test@example.com", "1234")).thenReturn(Optional.of(employee));
        EmployeeLogin useCase = new EmployeeLogin(new JWTTokenGenerator(), repository);
        assertEquals(true, useCase.execute("test@example.com", "1234").isPresent());
    }

    @Test
    void should_not_return_token() {
        EmployeeRepository repository = mock(EmployeeRepository.class);
        Mockito.when(repository.authenticate("test@example.com", "1234")).thenReturn(Optional.ofNullable(null));
        EmployeeLogin useCase = new EmployeeLogin(new JWTTokenGenerator(), repository);
        assertEquals(true, useCase.execute("test@example.com", "1234").isEmpty());
    }
}
