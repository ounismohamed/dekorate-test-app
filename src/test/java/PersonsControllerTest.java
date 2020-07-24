import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.keyrus.dekorateApp.*;
@SpringBootTest
public class PersonsControllerTest {
  @Test
public void findById() {

PersonRepository personRepository= new PersonRepository();
    Address address = new Address("Warsaw", "Test", "1", 1);
    Contact contact = new Contact("test1@example.com", "500500500");
    Social social = new Social("https://facebook.com/test1", "https://twitter.com/test1", "https://linkedin.com/test1");
    personRepository.add(new Person(null, "John Smith", 33, Gender.MALE, address, contact, social));

    address = new Address("Warsaw", "Test", "2", 2);
    contact = new Contact("test2@example.com", "500500502");
    social = new Social("https://facebook.com/test2", "https://twitter.com/test2", "https://linkedin.com/test2");
    personRepository.add(new Person(3, "Paul Walker", 44, Gender.MALE, address, contact, social));

    assert(personRepository.findById(3).getId().equals(new Person(3, "Paul Walker", 44, Gender.MALE, address, contact, social).getId()));

    }

    @Test
    public void failureTest() {
        assert (true);
    }
}