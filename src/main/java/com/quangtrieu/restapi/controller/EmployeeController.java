package com.quangtrieu.restapi.controller;

import com.quangtrieu.restapi.entity.Employee;
import com.quangtrieu.restapi.exception.EmployeeNotFoundException;
import com.quangtrieu.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        Employee employees = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeL = this.employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeL, HttpStatus.OK);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) throws EmployeeNotFoundException{
        Employee employee = this.employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        Employee updateEmployee = this.employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) throws EmployeeNotFoundException{
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
