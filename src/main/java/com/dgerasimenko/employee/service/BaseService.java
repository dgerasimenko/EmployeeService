package com.dgerasimenko.employee.service;

import java.util.List;

public interface BaseService<T> {

    void create(T employee);

    List<T> findAll();

    void update(T employee);

}
