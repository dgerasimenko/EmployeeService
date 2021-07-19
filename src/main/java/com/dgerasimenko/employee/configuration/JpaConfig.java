package com.dgerasimenko.employee.configuration;

import com.dgerasimenko.employee.dao.EmployeeRepository;
import com.dgerasimenko.employee.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
    private static final Logger log = LoggerFactory.getLogger(JpaConfig.class);
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("John", "manager")));
            log.info("Preloading " + repository.save(new Employee("Bob", "developer")));
            log.info("Preloading " + repository.save(new Employee("Moss", "support")));
        };
    }
}
