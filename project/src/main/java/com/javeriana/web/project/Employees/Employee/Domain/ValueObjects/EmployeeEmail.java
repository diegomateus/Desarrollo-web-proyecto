package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.Email;

public class EmployeeEmail extends Email {
    public EmployeeEmail() {
    }

    private EmployeeEmail(){
        super("");

    }

    public EmployeeEmail(String value) {
        super(value);
    }

}
