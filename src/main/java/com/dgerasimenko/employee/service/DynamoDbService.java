package com.dgerasimenko.employee.service;

import java.util.Optional;

public interface DynamoDbService<T> extends BaseService<T> {

    Optional<T> findById(String id);

    void delete(String id);
}
