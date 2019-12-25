package com.slemjet.dao;

import com.slemjet.entity.Person;

import java.util.List;

public interface PersonDao {
    Person add(Person person);

    List<Person> listPersons();
}
