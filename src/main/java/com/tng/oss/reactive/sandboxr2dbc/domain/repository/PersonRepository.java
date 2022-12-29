package com.tng.oss.reactive.sandboxr2dbc.domain.repository;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveCrudRepository<Person,Long> {
        Flux<Person> findByLastName(String lastName);
}
