package com.javeriana.web.project.Employees.Employee.Infrastructure.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class LoginPostController {
    //TODO: Autowired Application Class

    @PostMapping(value = "/login")
    public ResponseEntity<Token>
}
