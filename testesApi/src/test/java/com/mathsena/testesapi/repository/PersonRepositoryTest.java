package com.mathsena.testesapi.repository;


import com.mathsena.testesapi.models.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private Person person1;

    @BeforeEach
    void setUp() {
        person1 = new Person("Matheus", "Sena", "Rua Rainha Catarina, 21", "male", "mathsena07@hotmail.com");
        Person person2 = new Person("Rogério", "Ceni", "Rua Morumbi, 21", "male", "rceni@hotmail.com");
        personRepository.save(person1);
        personRepository.save(person2);
    }

    @AfterEach
    void tearDown() {
        personRepository.deleteAll();
    }

    @DisplayName("Should return a Person when saved")
    @Test
    void testSavePerson() {
        // When
        Person savedPerson = personRepository.save(new Person("John", "Doe", "Some Address", "male", "johndoe@email.com"));

        // Then
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);
    }

    @DisplayName("Testing findAll method on Person Repository")
    @Test
    void findAllPersonRepositoryTest() {
        // When
        List<Person> personList = personRepository.findAll();

        //Then
        assertNotNull(personList);
        assertEquals(2, personList.size());
    }

    @DisplayName("Testing findById method on Person Repository")
    @Test
    void findByIdPersonRepositoryTest() {
        // When
        Optional<Person> personReturnedOpt = personRepository.findById(person1.getId());

        //Then
        assertTrue(personReturnedOpt.isPresent());
        Person personReturned = personReturnedOpt.get();
        assertEquals(person1.getId(), personReturned.getId());
    }


    @DisplayName("Testing findByEmail method on Person Repository")
    @Test
    void findByEmailPersonRepositoryTest() {
        // When
        Optional<Person> personMail = personRepository.findByEmail(person1.getEmail());

        //Then
        assertTrue(personMail.isPresent());
        Person personReturned = personMail.get();
        assertEquals(person1.getId(), personReturned.getId());
    }
}
