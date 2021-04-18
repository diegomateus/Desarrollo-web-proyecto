package com.javeriana.web.project.Employees.Employee.Domain;

public class Employee {
    private EmployeeId employeeId;
    private EmployeeEmail employeeEmail;
    private EmployeePassword employeePassword;
    private EmployeeFirstName employeeFirstName;
    private EmployeeLastName employeeLastName;
    private EmployeeIsAdministrator employeeIsAdministrator;

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
}
