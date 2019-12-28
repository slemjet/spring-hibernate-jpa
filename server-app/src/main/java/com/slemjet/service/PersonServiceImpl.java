package com.slemjet.service;

import com.slemjet.dao.PersonDao;
import com.slemjet.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao userDao;

    public PersonServiceImpl(PersonDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> getAll() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public Person add(Person person) {
        return userDao.add(person);
    }

    @Transactional
    @Override
    public Person update(Person person) {
        return userDao.update(person);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void delete(List<Long> ids) {
        userDao.delete(ids);
    }
}
