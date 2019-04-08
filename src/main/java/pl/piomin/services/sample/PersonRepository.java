package pl.piomin.services.sample;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    List<Person> persons = new ArrayList<>();

    public Person add(Person person) {
        person.setId(persons.size()+1);
        persons.add(person);
        return person;
    }

    public Person findById(Long id) {
        Optional<Person> person = persons.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (person.isPresent())
            return person.get();
        else
            return null;
    }

    public List<Person> findAll() {
        return persons;
    }

}
