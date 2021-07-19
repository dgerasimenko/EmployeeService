package com.dgerasimenko.employee.service;

import com.dgerasimenko.employee.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void create(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    void update(Employee employee);

    void delete(Long id);
}
