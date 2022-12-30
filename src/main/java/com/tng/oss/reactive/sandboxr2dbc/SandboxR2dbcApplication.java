package com.tng.oss.reactive.sandboxr2dbc;

import com.tng.oss.reactive.sandboxr2dbc.domain.model.Person;
import com.tng.oss.reactive.sandboxr2dbc.domain.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class SandboxR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxR2dbcApplication.class, args);
	}


    @Bean
    public CommandLineRunner demo(PersonRepository repository) {

        return (args) -> {
            // save a few customers
            repository.saveAll(Arrays.asList(Person.of("Jack", "Bauer"),
                            Person.of("Chloe", "O'Brian"),
                            Person.of("Kim", "Bauer"),
                            Person.of("David", "Palmer"),
                            Person.of("Michelle", "Dessler")))
                    .blockLast(Duration.ofSeconds(10));

            // fetch all customers
            log.info("Persons found with findAll():");
            log.info("-------------------------------");
            repository.findAll().doOnNext(customer -> {
                log.info(customer.toString());
            }).blockLast(Duration.ofSeconds(10));

            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L).doOnNext(customer -> {
                log.info("Person found with findById(1L):");
                log.info("--------------------------------");
                log.info(customer.toString());
                log.info("");
            }).block(Duration.ofSeconds(10));


            // fetch customers by last name
            log.info("Person found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").doOnNext(bauer -> {
                log.info(bauer.toString());
            }).blockLast(Duration.ofSeconds(10));;
            log.info("");
        };
    }
}
