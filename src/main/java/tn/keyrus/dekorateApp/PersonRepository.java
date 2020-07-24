package tn.keyrus.dekorateApp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

@Repository
public class PersonRepository {

    List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void init() {
        Address address = new Address("Warsaw", "Test", "1", 1);
        Contact contact = new Contact("test1@example.com", "500500500");
        Social social = new Social("https://facebook.com/test1", "https://twitter.com/test1", "https://linkedin.com/test1");
        add(new Person(null, "John Smith", 33, Gender.MALE, address, contact, social));

        address = new Address("Warsaw", "Test", "2", 2);
        contact = new Contact("test2@example.com", "500500502");
        social = new Social("https://facebook.com/test2", "https://twitter.com/test2", "https://linkedin.com/test2");
        add(new Person(null, "Paul Walker", 44, Gender.MALE, address, contact, social));
    }

    public Person add(Person person) {
        person.setId(persons.size()+1);
        persons.add(person);
        return person;
    }

    public Person findById(Integer id) {
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
