package com.tng.oss.reactive.sandboxr2dbc.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Person {
    @Id
    private Long id;

    private final String firstName;
    private final String lastName;
}
