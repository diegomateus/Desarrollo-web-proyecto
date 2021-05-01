package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class EmployeePassword extends StringValueObject {

    public EmployeePassword(String value) {
        super(value);
        this.validate(value);
    }

    public EmployeePassword() {
    }

    private void validate(String value) {
        this.lengthRule(value);
    }

    private void lengthRule(String value) {
        if(value.length() < 3 || value.length() > 200) {
            throw new InvalidLength("Invalid number of characters");
        }
    }
}
