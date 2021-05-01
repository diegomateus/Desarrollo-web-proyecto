package com.javeriana.web.project.Employees.Employee.Domain;

public class EmployeeNotExist extends RuntimeException{
    public EmployeeNotExist(String message){
        super(message);
    }
}
