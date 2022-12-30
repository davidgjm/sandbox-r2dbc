package com.tng.oss.reactive.sandboxr2dbc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@AllArgsConstructor
@Data
public class Employee {
    @Id
    private final Long id;
    private final String firstName;
    private final String lastName;

    private String email;

    public static Employee of(String firstName, String lastName, String email) {
        return new Employee(null, firstName, lastName, email);
    }
}
