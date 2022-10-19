package com.example.demo1.api;

import com.example.demo1.modle.Person;
import com.example.demo1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    //post on route ("api/v1/person")
    @PostMapping
    public void addPerson(@NonNull @Validated @RequestBody Person person) {
        personService.addPerson(person);
    }

    //get on route ("api/v1/person")
    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    //get on route ("api/v1/person/id")
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    //delete person by id
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    //updating Person.
    @PutMapping(path = "{id}")
    public  void updatePersonById(@PathVariable("id") UUID id,@NonNull @Validated @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}
