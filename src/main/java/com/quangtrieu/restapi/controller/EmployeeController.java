package com.quangtrieu.restapi.controller;

import com.quangtrieu.restapi.entity.Employee;
import com.quangtrieu.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employees = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeL = this.employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeL, HttpStatus.OK);
    }
}
