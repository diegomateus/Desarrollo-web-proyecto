package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.StringValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeEmail extends StringValueObject {

    public EmployeeEmail(String value) {
        super(value);
    }

}
