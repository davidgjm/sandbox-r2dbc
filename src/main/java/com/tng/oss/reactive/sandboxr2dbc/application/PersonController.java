package com.tng.oss.reactive.sandboxr2dbc.application;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Person;
import com.tng.oss.reactive.sandboxr2dbc.domain.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/persons")
@RestController
public class PersonController {
    private final PersonService service;

    @GetMapping
    public Flux<Person> findPersons() {
        log.info("Querying current persons in database");
        return service.findAll()
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(Person -> log.info("Persisted entity: {}", Person))
                ;
    }

    @PostMapping
    public Mono<PersonDto> save(@RequestBody Mono<PersonDto> requestBody) {
        return requestBody
                .publishOn(Schedulers.boundedElastic())
                .map(PersonDto::Person)
                .flatMap(service::save)
                .map(PersonDto::from)
                ;
    }

}
