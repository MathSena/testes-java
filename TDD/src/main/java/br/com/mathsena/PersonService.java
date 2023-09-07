package br.com.mathsena;

public class PersonService implements PersonServiceInterface{
    @Override
    public Person createPerson(Person person) {
        if(person.getEmail().isEmpty()){
            throw new IllegalArgumentException("The person e-mail is null or empty");
        }

        return person;
    }
}
