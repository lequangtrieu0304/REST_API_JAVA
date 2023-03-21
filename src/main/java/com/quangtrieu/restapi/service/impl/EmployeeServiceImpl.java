package com.quangtrieu.restapi.service.impl;

import com.quangtrieu.restapi.entity.Employee;
import com.quangtrieu.restapi.exception.EmployeeNotFoundException;
import com.quangtrieu.restapi.repository.EmployeeRepository;
import com.quangtrieu.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) throws EmployeeNotFoundException{
        try {
            return employeeRepository.findById(id).get();
        }
        catch (Exception e) {
            throw new EmployeeNotFoundException("Not Found " + id);
        }
    }

    @Override
    public Employee updateEmployee(long id, Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) throws EmployeeNotFoundException {
        try {
            employeeRepository.deleteById(id);
        }
        catch (Exception e){
            throw new EmployeeNotFoundException("Not found "+id);
        } 
    }
}
