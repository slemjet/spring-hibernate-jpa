package com.slemjet.service;

import com.slemjet.entity.Person;

import java.util.List;

public interface PersonService {
    Person add(Person person);

    List<Person> listPersons();
}
