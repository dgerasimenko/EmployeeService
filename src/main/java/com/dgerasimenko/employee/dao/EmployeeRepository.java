package com.dgerasimenko.employee.dao;

import com.dgerasimenko.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
