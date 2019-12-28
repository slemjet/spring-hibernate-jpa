package com.slemjet;

import com.slemjet.entity.Person;
import com.slemjet.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class MainApp {
    private static Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApp.class, args);

        PersonService personService = applicationContext.getBean(PersonService.class);

        // Add Persons
        personService.add(new Person("User1", "User1", "us1@example.com"));
        personService.add(new Person("User2", "User2", "us2@example.com"));
        personService.add(new Person("User3", "User3", "us3@example.com"));
        personService.add(new Person("User4", "User4", "us4@example.com"));

        // Get Persons
        List<Person> persons = personService.getAll();
        for (Person person : persons)
            log.info("Person = " + person);

    }
}
