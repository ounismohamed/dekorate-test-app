package tn.keyrus.dekorateApp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    private Integer id;
    private String name;
    private int age;
    private Gender gender;
    private Address address;
    private Contact contact;
    private Social social;

}
