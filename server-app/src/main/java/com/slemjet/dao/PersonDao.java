package com.slemjet.dao;

import com.slemjet.entity.Person;

import java.util.List;

public interface PersonDao {
    Person add(Person person);

    Person get(Long id);

    List<Person> getAll();

    Person update(Person person);

    void delete(Long id);

    void delete(List<Long> ids);
}
