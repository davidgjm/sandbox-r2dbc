package com.tng.oss.reactive.sandboxr2dbc.application;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Employee;
import com.tng.oss.reactive.sandboxr2dbc.domain.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public Flux<Employee> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Employee> save(@RequestBody Mono<Employee> employee) {
        log.info("Saving employee {}", employee);
        return employee.publishOn(Schedulers.boundedElastic())
                .flatMap(service::save)
                .log()
                ;
    }
}
