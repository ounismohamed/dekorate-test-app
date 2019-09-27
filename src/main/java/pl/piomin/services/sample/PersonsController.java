package pl.piomin.services.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonsController.class);

    @Autowired
    PersonRepository repository;

    @Value(value = "${showAddress:false}")
    Optional<Boolean> showAddress;
    @Value(value = "${showContactInfo:false}")
    Optional<Boolean> showContactInfo;
    @Value(value = "${showSocial:false}")
    Optional<Boolean> showSocial;

    @PostMapping
    public Person add(@RequestBody Person person) {
        LOGGER.info("Person add: {}", person);
        return repository.add(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Integer id) {
        LOGGER.info("Person find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        LOGGER.info("Person find");
        return repository.findAll();
    }

}
