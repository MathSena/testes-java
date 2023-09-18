package com.mathsena.testesapi.repository;

import com.mathsena.testesapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);


    @Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
    Person findByJPQL(String firstName, String lastName);
}
