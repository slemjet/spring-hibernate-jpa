package com.slemjet.service;

import com.slemjet.dao.PersonDao;
import com.slemjet.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao userDao;

    public PersonServiceImpl(PersonDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public Person add(Person person) {
        return userDao.add(person);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> listPersons() {
        return userDao.listPersons();
    }

}
