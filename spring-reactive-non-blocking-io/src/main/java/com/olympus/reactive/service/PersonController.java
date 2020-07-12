//package com.olympus.reactive.service;
//
//import com.github.f4b6a3.uuid.UuidCreator;
//import com.github.javafaker.Faker;
//import com.olympus.reactive.couchbase.dto.Person;
//import com.olympus.reactive.couchbase.repositories.PersonRepository;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Schedulers;
//
//import java.util.UUID;
//
//@Log4j2
//@RestController
//@RequestMapping("/")
//public class PersonController {
//
//    private final PersonRepository personRepository;
//
//    final Faker faker = new Faker();
//
//    public PersonController(PersonRepository personRepository){
//        this.personRepository = personRepository;
//    }
//
//    @GetMapping("/test-endpoint")
//    @ResponseStatus(HttpStatus.OK)
//    public Mono<String> testFlow() {
//
//        //non-blocking uuid generator
//        UUID id = UuidCreator.getRandomBased();
//        final Person person = new Person(id, "ben" );//faker.name().firstName());
//        log.info("new request , generated person id: "+id);
//
//        return Mono.when(personRepository.save(person))
//                .flatMap(then -> personRepository.findById(id))
//                .flatMap(then -> personRepository.deleteById(id))
//                .flatMap(then-> Mono.just("Person controller: new person was written -> read -> deleted"));
////                .then(personRepository.save(person))
////                .then(personRepository.findById(id))
////                .then(personRepository.deleteById(id))
////                .then(Mono.just("Person controller: new person was written -> read -> deleted"))
////                .retry(50);
////                .subscribeOn(Schedulers.parallel())
////                .publishOn(Schedulers.parallel())
////                .delaySubscription(Duration.ofSeconds(1))
////                .retry(100);
//////                .publishOn(Schedulers.parallel())
////                .subscribeOn(Schedulers.parallel());
//    }
//
//    @GetMapping("/create-person")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<String> countByBalance(@RequestParam String id) {
//        final Person person = new Person(UUID.fromString(id), faker.name().firstName());
//        return personRepository
//                .save(person)
//                .thenReturn("Person controller: new person created: "+id);
//    }
//
//    @GetMapping("/get-person")
//    @ResponseStatus(HttpStatus.OK)
//    public Mono<Person> findById(@RequestParam String id) {
//        return personRepository.findById(UUID.fromString(id));
//    }
//
//    @DeleteMapping("/delete-person")
//    @ResponseStatus(HttpStatus.OK)
//    public Mono<String> removePerson(@RequestParam String id) {
//        return personRepository.deleteById(UUID.fromString(id))
//                .thenReturn("Person controller: deleted person id: "+id);
//    }
//
//    //"Person controller: deleted person id: "+person.getId()
//}
