package com.slemjet.dao;

import com.slemjet.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Person get(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        CriteriaQuery<Person> criteriaQuery = em.getCriteriaBuilder().createQuery(Person.class);
        @SuppressWarnings("unused")
        Root<Person> root = criteriaQuery.from(Person.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Person add(Person person) {
        em.persist(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        em.merge(person);
        return person;
    }

    @Override
    public void delete(Long id) {
        delete(Collections.singletonList(id));
    }

    @Override
    public void delete(List<Long> ids) {
        int result = em.createQuery("DELETE FROM Person p WHERE p.id IN :ids")
                .setParameter("ids", ids)
                .executeUpdate();
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        Root<Person> person = criteriaBuilder.createQuery().from(Person.class);
//        CriteriaDelete<Person> criteriaDelete = criteriaBuilder.createCriteriaDelete(Person.class);
//
//        int id = em.createQuery(criteriaDelete.where(person.get("id").in(ids))).executeUpdate();
        System.out.println("executed " + result);
    }
}
