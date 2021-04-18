package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class EmployeeLastName extends StringValueObject {

    public EmployeeLastName(String value) {
        super(value);
        this.validate(value);
    }

    public void validate(String value) {
        this.lengthRule(value);
    }

    public void lengthRule(String value) {
        if(value.length() < 3 || value.length() > 200) {
            throw new InvalidLength("Invalid number of characters");
        }
    }
}
