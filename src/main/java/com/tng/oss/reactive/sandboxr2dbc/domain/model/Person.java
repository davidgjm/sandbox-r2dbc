package com.tng.oss.reactive.sandboxr2dbc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@AllArgsConstructor
@Data
public class Person {
    @Id
    private final Long id;
    private final String firstName;
    private final String lastName;

    public static Person of(String firstName, String lastName) {
        return new Person(null, firstName, lastName);
    }
}
