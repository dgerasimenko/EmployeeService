package com.dgerasimenko.employee.service;

import java.util.Optional;

public interface RDBMSService<T> extends BaseService<T> {

    Optional<T> findById(Long id);

    void delete(Long id);

}
