package com.dgerasimenko.employee.controller;

import com.dgerasimenko.employee.entity.dynamodb.Department;
import com.dgerasimenko.employee.service.DynamoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    private final DynamoDbService<Department> departmentService;

    @Autowired
    public DepartmentController(@Qualifier("departmentService") DynamoDbService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public ResponseEntity<List<Department>> findAll() {
        final List<Department> departments = departmentService.findAll();

        return departments != null &&  !departments.isEmpty()
                ? new ResponseEntity<>(departments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> findById(@PathVariable(name = "id") String id) {
        final Optional<Department> department = departmentService.findById(id);

        return department.isPresent()
                ? new ResponseEntity<>(department.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/department")
    public ResponseEntity<?> create(@RequestBody Department department) {
        departmentService.create(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

