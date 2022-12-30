package com.tng.oss.reactive.sandboxr2dbc.domain.service;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Employee;
import com.tng.oss.reactive.sandboxr2dbc.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public Mono<Employee> save(Employee employee) {
        return repository.save(employee);
    }

    public Mono<Employee> findById(Long id) {
        return repository
                .findById(id)
                .cache()
                .log()
                ;
    }

    public Flux<Employee> findAll() {
        return repository.findAll();
    }
}
