package com.example.demo1.modle;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

public class Person {

    private final UUID id;
    @NonNull
    private final String name;

    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
