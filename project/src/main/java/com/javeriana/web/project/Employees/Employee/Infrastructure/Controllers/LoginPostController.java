package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import com.javeriana.web.project.Employees.Employee.Application.Login.EmployeeLogin;
import com.javeriana.web.project.Shared.Domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class LoginPostController {

    @Autowired
    EmployeeLogin employeeLogin;

    @PostMapping(value = "/login")
    public ResponseEntity<Token> execute(@RequestBody Request request) {
        Optional<Token> token = employeeLogin.execute(request.getEmail(), request.getPassword());
        if(token.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(token.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping(value = "/test")
    public ResponseEntity test() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
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
