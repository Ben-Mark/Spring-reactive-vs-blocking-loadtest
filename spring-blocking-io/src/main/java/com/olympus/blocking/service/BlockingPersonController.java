package com.olympus.blocking.service;


import com.github.javafaker.Faker;
import com.olympus.blocking.couchbase.model.Person;
import com.olympus.blocking.couchbase.repo.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class BlockingPersonController {

    private final PersonRepository personRepository;
    final Faker faker = new Faker();

    public BlockingPersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @GetMapping("/test-endpoint")
    @ResponseBody
    public ResponseEntity<?> get() {
        final UUID id = UUID.randomUUID();

        final Person person = new Person(id, faker.name().firstName());

//        log.info("new request , generated person id: "+id);
        try {
            personRepository.save(person);
            personRepository.findById(id);
            personRepository.deleteById(id);
            return new ResponseEntity<String>("Person controller: new person was written -> read -> deleted",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>("failed at test flow",HttpStatus.CONFLICT);
        }

    }


    @GetMapping("/get-object-blocking")
    @ResponseBody
    public ResponseEntity<?> get(@RequestParam String id) {
        Optional<Person> newPerson = personRepository.findById(UUID.fromString(id));//.orElseThrow(()-> new Exception("Test failure: couchbase document doesnt exist right-after insertion"));

        if(newPerson.isPresent()){
            return new ResponseEntity<Person>(newPerson.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("object doesn't exist",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/save-object-blocking", consumes = "application/json", produces = "application/json")
//    @ResponseBody
    public ResponseEntity<?> saveObject(@RequestBody Person person) {
        try {
            personRepository.save(person);
            return new ResponseEntity<String>("Item saved successfully",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "/remove-object-blocking", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> remove(@RequestParam String id) {
        try {
            personRepository.deleteById(UUID.fromString(id));
            return new ResponseEntity<String>("Item deleted successfully",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}

