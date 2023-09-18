package com.mathsena.testesapi.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;

import com.mathsena.testesapi.exception.ResourceNotFoundException;
import com.mathsena.testesapi.models.Person;
import com.mathsena.testesapi.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    private Person person0;

    private Person createPerson(String firstName, String email) {
        return new Person(
                firstName,
                "Sena",
                email,
                "Rua Rainha Catarina, 21",
                "Male");
    }

    @BeforeEach
    public void setup() {
        person0 = createPerson("Matheus", "mathsena07@hotmail.com");
    }

    @DisplayName("Test findAll returns all persons")
    @Test
    void testFindAll() {
        Person person1 = createPerson("Matheus", "mathsena07@hotmail.com");
        given(repository.findAll()).willReturn(List.of(person0, person1));

        List<Person> result = service.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @DisplayName("Test findAll returns an empty list")
    @Test
    void testFindAllReturnsEmpty() {
        given(repository.findAll()).willReturn(Collections.emptyList());

        List<Person> result = service.findAll();

        assertTrue(result.isEmpty());
    }

    @DisplayName("Test findById returns person")
    @Test
    void testFindById() {
        given(repository.findById(1L)).willReturn(Optional.of(person0));

        Person result = service.findById(1L);

        assertNotNull(result);
        assertEquals("Matheus", result.getFirstName());
    }

    @DisplayName("Test findById throws exception for non-existent person")
    @Test
    void testFindByIdThrowsException() {
        given(repository.findById(1L)).willReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.findById(1L));
    }

    @DisplayName("Test create new person")
    @Test
    void testCreate() {
        given(repository.findByEmail("leandro@erudio.com.br")).willReturn(Optional.empty());
        given(repository.save(person0)).willReturn(person0);

        Person result = service.create(person0);

        assertNotNull(result);
        assertEquals("Leandro", result.getFirstName());
    }

    @DisplayName("Test create throws exception for duplicate email")
    @Test
    void testCreateThrowsExceptionForDuplicateEmail() {
        given(repository.findByEmail("mathsena07@hotmail.com")).willReturn(Optional.of(person0));

        assertThrows(ResourceNotFoundException.class, () -> service.create(person0));
    }

    @DisplayName("Test update existing person")
    @Test
    void testUpdate() {
        person0.setId(1L);
        given(repository.findById(1L)).willReturn(Optional.of(person0));

        Person updatedDetails = createPerson("Leonardo", "leonardo@erudio.com.br");
        given(repository.save(updatedDetails)).willReturn(updatedDetails);

        Person result = service.update(updatedDetails);

        assertNotNull(result);
        assertEquals("Matheus", result.getFirstName());
    }

    @DisplayName("Test update throws exception for non-existent person")
    @Test
    void testUpdateThrowsExceptionForInvalidId() {
        person0.setId(1L);

        given(repository.findById(1L)).willReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.update(person0));
    }

    @DisplayName("Test delete person by ID")
    @Test
    void testDelete() {
        person0.setId(1L);
        given(repository.findById(1L)).willReturn(Optional.of(person0));

        service.delete(1L);

        verify(repository).delete(person0);
    }

    @DisplayName("Test delete throws exception for non-existent person")
    @Test
    void testDeleteThrowsExceptionForInvalidId() {
        given(repository.findById(1L)).willReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.delete(1L));
    }
}