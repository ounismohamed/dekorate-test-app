package pl.piomin.services.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonsController.class);

    @Autowired
    PersonRepository repository;

    @PostMapping
    public Person add(@RequestBody Person person) {
        LOGGER.info("Person add: {}", person);
        return repository.add(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id) {
        LOGGER.info("Person find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        LOGGER.info("Person find");
        return repository.findAll();
    }

}
