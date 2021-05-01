package com.javeriana.web.project.Employees.Employee.Domain;

import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;

import java.util.HashMap;

public class Employee {
    private EmployeeId employeeId;
    private EmployeeEmail employeeEmail;
    private EmployeePassword employeePassword;
    private EmployeeFirstName employeeFirstName;
    private EmployeeLastName employeeLastName;
    private EmployeeIsAdministrator employeeIsAdministrator;

    public Employee() {
    }

    public Employee(
            EmployeeId employeeId,
            EmployeeEmail employeeEmail,
            EmployeePassword employeePassword,
            EmployeeFirstName employeeFirstName,
            EmployeeLastName employeeLastName,
            EmployeeIsAdministrator employeeIsAdministrator
    ) {
        this.employeeId = employeeId;
        this.employeeEmail = employeeEmail;
        this.employeePassword = employeePassword;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeIsAdministrator = employeeIsAdministrator;
    }

    public HashMap<String, String> data() {
        HashMap<String, String> data = new HashMap<>() {{
            put("id", employeeId.value());
            put("email", employeeEmail.value());
            put("first_name", employeeFirstName.value());
            put("last_name", employeeLastName.value());
            put("password", employeePassword.value());
            put("is_admin", employeeIsAdministrator.value().toString());
        }};
        return data;
    }
}
