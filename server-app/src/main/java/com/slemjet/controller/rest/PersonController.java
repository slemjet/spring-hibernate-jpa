package com.slemjet.controller.rest;

import com.slemjet.entity.Person;
import com.slemjet.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/person")
@CrossOrigin
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> listPersons() {
        return personService.getAll();
    }

    @PostMapping()
    public Person add(@RequestBody Person person) {
        return personService.add(person);
    }

    @PutMapping()
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    @DeleteMapping()
    public void delete(@RequestBody List<Long> ids) {
        personService.delete(ids);
    }
}
