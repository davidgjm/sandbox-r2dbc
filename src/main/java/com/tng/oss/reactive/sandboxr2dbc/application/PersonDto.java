package com.tng.oss.reactive.sandboxr2dbc.application;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Person;

public record PersonDto(String firstName, String lastName) {
    public Person Person() {
        return Person.of(firstName, lastName);
    }

    public static PersonDto from(Person person) {
        return new PersonDto(person.getFirstName(), person.getLastName());
    }
}
