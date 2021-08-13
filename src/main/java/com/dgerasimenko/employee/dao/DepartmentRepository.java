package com.dgerasimenko.employee.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.dgerasimenko.employee.entity.dynamodb.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public DepartmentRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Department findById(String id) {
        return dynamoDBMapper.load(Department.class, id);
    }

    public List<Department> findAll() {
        return dynamoDBMapper.scan(Department.class, new DynamoDBScanExpression());
    }

    public Department save(Department department) {
        dynamoDBMapper.save(department);
        return department;
    }
    public void delete(String id) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Department.class, id));
    }
}
