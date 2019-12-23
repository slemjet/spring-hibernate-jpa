package com.slemjet.controller.rest;

import com.slemjet.entity.Person;
import com.slemjet.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public Person add(@RequestBody Person person) {
        return personService.add(person);
    }

    @GetMapping
    public List<Person> listPersons() {
        return personService.listPersons();
    }
}
