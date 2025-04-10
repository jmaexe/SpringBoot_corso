package com.demo.tutorial.person;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public void update(Long id, PersonDTO personDTO) {
        personRepository.save(new Person(id, personDTO.getNome(), personDTO.getCognome(), personDTO.getEta()));
    }

    // @Transactional
    // public void savePerson(Person person) {
    // entityManager.persist(person);
    // }

    // @Transactional
    // public void saveAll(List<Person> list) {
    // for (Person person : list) {
    // entityManager.persist(person);
    // }
    // }

    // public List<Person> getAll() {
    // TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person
    // p", Person.class);
    // return query.getResultList();
    // }

    // public Person getPersonPerId(Long id) {
    // Person query = entityManager.find(Person.class, id);
    // return query;
    // }

    // @Transactional
    // public void deletePersonPerId(Long id) {
    // Person p = entityManager.find(Person.class, id);
    // if (p != null) {
    // entityManager.remove(p);
    // }

    // }

    // @Transactional
    // public void updatePerson(Person p) {
    // System.out.println(p);
    // // Person person = entityManager.find(Person.class, id);
    // // person.setCognome(p.getCognome());
    // // person.setNome(p.getNome());
    // // person.setEta(p.getEta());
    // // entityManager.merge(person);
    // entityManager.refresh(p);
    // ;
    // }
}
