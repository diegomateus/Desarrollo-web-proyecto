package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class EmployeeLastName extends StringValueObject {

    private EmployeeLastName(){
        super("");
    }
    public EmployeeLastName(String value) {
        super(value);
        this.validate(value);
    }

    private void validate(String value) {
        this.lengthRule(value);
    }

    private void lengthRule(String value) {
        if(value.length() < 1 || value.length() > 200) {
            throw new InvalidLength("Invalid number of characters");
        }
    }
}
