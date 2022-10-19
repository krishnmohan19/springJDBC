package com.example.demo1.dao;

import com.example.demo1.modle.Person;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(@JsonProperty("id") UUID id,@JsonProperty("name") Person person);


    default int insertPerson(Person person) {
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> selectAllPerson();

    int deletePersonById(UUID id);
    int updatePersonById(UUID id,Person person);

    Optional<Person> selectPersonById(UUID id);
}
