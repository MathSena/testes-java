import br.com.mathsena.Person;
import br.com.mathsena.PersonService;
import br.com.mathsena.PersonServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    private Person person;
    private PersonServiceInterface service;

    @BeforeEach
    void setup() {
        person = new Person(1L, "Matheus", "Sena", "Tottenham - UK", "Male", "mathsena07@hotmail.com");
        service = new PersonService();
    }

    @DisplayName("When creating a Person with success, it should return a Person object")
    @Test
    void testCreatePersonWithSuccess() {
        Person actual = service.createPerson(person);
        assertNotNull(actual, "The createPerson() method should not return null");
    }

    @DisplayName("When creating a Person with success, the returned Person should have the same first name")
    @Test
    void testCreatePersonWithSuccessShouldContainFirstName() {
        Person actual = service.createPerson(person);
        assertEquals(person.getFirstName(), actual.getFirstName(), "The returned Person's first name should match the input Person's first name");
    }

    @DisplayName("When creating a Person, the returned Person should have the same last name")
    @Test
    void testCreatePersonShouldContainLastName() {
        Person actual = service.createPerson(person);
        assertEquals(person.getLastName(), actual.getLastName(), "The returned Person's last name should match the input Person's last name");
    }

    @DisplayName("When creating a Person, the returned Person should have the same address")
    @Test
    void testCreatePersonShouldContainAddress() {
        Person actual = service.createPerson(person);
        assertEquals(person.getAddress(), actual.getAddress(), "The returned Person's address should match the input Person's address");
    }

    @DisplayName("When creating a Person, the returned Person should have the same gender")
    @Test
    void testCreatePersonShouldContainGender() {
        Person actual = service.createPerson(person);
        assertEquals(person.getGender(), actual.getGender(), "The returned Person's gender should match the input Person's gender");
    }

    @DisplayName("When creating a Person, the returned Person should have the same email")
    @Test
    void testCreatePersonShouldContainEmail() {
        Person actual = service.createPerson(person);
        assertEquals(person.getEmail(), actual.getEmail(), "The returned Person's email should match the input Person's email");
    }

    @Test
    void testCreatePersonWithInvalidEmailShouldThrowException() {
        // Given an invalid email
        person = new Person(1L, "Matheus", "Sena", "Tottenham - UK", "Male", "");

        // Assert that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            service.createPerson(person);
        }, "Expected createPerson() to throw IllegalArgumentException for invalid email, but it didn't");
    }
}
