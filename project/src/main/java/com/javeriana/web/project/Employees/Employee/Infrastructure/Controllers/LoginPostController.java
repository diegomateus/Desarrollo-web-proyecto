package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Employees.Employee.Application.Login.EmployeeLogin;
import com.javeriana.web.project.Shared.Domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class LoginPostController {

    @Autowired
    EmployeeLogin employeeLogin;

    @PostMapping(value = "/login")
    public ResponseEntity<Token> execute(@RequestBody Request request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        Token token = employeeLogin.execute(request.getEmail(), request.getPassword());
        if(token != null) {
            status = HttpStatus.OK;
        }
        return ResponseEntity.status(status).body(token);
    }

    static class Request {
        private String email;
        private String password;

        public Request() {
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
