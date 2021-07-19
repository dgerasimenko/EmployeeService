package com.dgerasimenko.employee.controller;

import com.dgerasimenko.employee.entity.Employee;
import com.dgerasimenko.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(@Qualifier("employeeServiceDemo")EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> findAll() {
        final List<Employee> employees = employeeService.findAll();

        return employees != null &&  !employees.isEmpty()
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable(name = "id") Long id) {
        final Optional<Employee> employee = employeeService.findById(id);

        return employee.isPresent()
                ? new ResponseEntity<>(employee.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        employeeService.create(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

