package com.tng.oss.reactive.sandboxr2dbc.domain.repository;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EmployeeRepository extends R2dbcRepository<Employee, Long> {
}
