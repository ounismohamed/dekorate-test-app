package pl.piomin.services.sample;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private Integer id;
    private String name;
    private int age;
    private Gender gender;
    private Address address;
    private Contact contact;
    private Social social;

}
