package com.tng.oss.reactive.sandboxr2dbc.domain.service;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Person;
import com.tng.oss.reactive.sandboxr2dbc.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class PersonService {
    private final PersonRepository repository;

    public Mono<Person> save(Person person) {
        log.info("Attempting to save {}", person);
        return repository.save(person);
    }

    public Flux<Person> findByLastName(String name) {
        return repository.findByLastName(name);
    }

    public Flux<Person> findAll() {
        return repository.findAll();
    }
}
