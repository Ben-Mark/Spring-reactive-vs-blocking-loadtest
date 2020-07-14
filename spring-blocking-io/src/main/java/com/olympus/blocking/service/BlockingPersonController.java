package com.olympus.blocking.service;


import com.olympus.blocking.couchbase.model.Person;
import com.olympus.blocking.couchbase.repo.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Log4j2
@RestController
public class BlockingPersonController {

    private final PersonRepository personRepository;


    public BlockingPersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @GetMapping("/test-endpoint")
    @ResponseBody
    public ResponseEntity<?> get() {
        final UUID id = UUID.randomUUID();
        final Person person = new Person(id, "person-name");

        log.info("new request , generated person id: "+id);
        try {
            personRepository.save(person);
            personRepository.findById(id);
            personRepository.deleteById(id);
            return new ResponseEntity<String>("Person controller: new person was written -> read -> deleted",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>("failed at test flow",HttpStatus.CONFLICT);
        }

    }


}

