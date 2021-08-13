package com.dgerasimenko.employee.service;

import com.dgerasimenko.employee.dao.DepartmentRepository;
import com.dgerasimenko.employee.entity.dynamodb.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements DynamoDbService<Department> {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department employee) {
        departmentRepository.save(employee);
    }

    @Override
    public List<Department> findAll() {
        List<Department> result = departmentRepository.findAll();
        return result == null ? new ArrayList<>() : result;
    }

    @Override
    public Optional<Department> findById(String id) {
        return Optional.ofNullable(departmentRepository.findById(id));
    }

    @Override
    public void update(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(String id) {
        departmentRepository.delete(id);
    }
}
