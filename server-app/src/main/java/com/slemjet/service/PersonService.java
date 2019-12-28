package com.slemjet.service;

import com.slemjet.entity.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    @Transactional
    Person update(Person person);

    @Transactional
    Person add(Person person);

    @Transactional
    void delete(Long id);

    @Transactional
    void delete(List<Long> ids);
}
