package com.mathsena.testesapi.repository;

import com.mathsena.testesapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
