package com.javeriana.web.project.controllers;

import com.javeriana.web.project.models.Employee;
import com.javeriana.web.project.models.Token;
import com.javeriana.web.project.models.EmployeeLogin;
import com.javeriana.web.project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Token> login (@RequestBody EmployeeLogin employee){
        //TODO: IMPLEMENTAR LOGIN
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEmployee (@RequestBody Employee employee){
        //TODO: IMPLEMENTAR createEmployee
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteEmployee (){
        //TODO: IMPLEMENTAR deleteEmployee
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }
}
