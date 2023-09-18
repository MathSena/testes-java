package com.mathsena.testesapi.services;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.mathsena.testesapi.exception.ResourceNotFoundException;
import com.mathsena.testesapi.models.Person;
import com.mathsena.testesapi.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        log.info("Fetching all people from the database.");
        return repository.findAll();
    }

    public Person findById(Long id) {
        log.info("Fetching person with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID: " + id));
    }

    public Person create(Person person) {
        log.info("Creating a new person with e-mail: {}", person.getEmail());

        Optional<Person> savedPerson = repository.findByEmail(person.getEmail());
        if (savedPerson.isPresent()) {
            throw new ResourceNotFoundException(
                    "Person already exists with given e-Mail: " + person.getEmail());
        }
        return repository.save(person);
    }

    public Person update(Person person) {
        log.info("Updating person with ID: {}", person.getId());

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID: " + person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        log.info("Deleting person with ID: {}", id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID: " + id));
        repository.delete(entity);
    }
}
