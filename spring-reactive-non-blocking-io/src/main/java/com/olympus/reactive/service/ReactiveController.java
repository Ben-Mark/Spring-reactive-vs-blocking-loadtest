//package com.olympus.reactive.service;
//
//import com.olympus.reactive.couchbase.dto.Person;
//import com.olympus.reactive.couchbase.repositories.N1QLPersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.UUID;
//
//@RestController
//public class ReactiveController {
//
//    private final N1QLPersonRepository personRepository;
//
//    public ReactiveController(N1QLPersonRepository personRepository){
//        this.personRepository = personRepository;
//    }
//
//    @PostMapping(value = { "/save-person"})
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<ServerResponse> create(@RequestBody Person person) {
//        return personRepository
//                .save(person)
//                .then(ServerResponse.ok()
//                        .contentType(MediaType.TEXT_PLAIN)
//                        .body(BodyInserters.fromValue("Reactive controller: new person created: "+person.getFirstName()))
//                );
//
//    }
//
//
//    @GetMapping(value = "/get-person")
//    @ResponseStatus(HttpStatus.OK)
//    public Mono<ServerResponse> findById(@RequestParam UUID id) {
//        final Mono<Person> personById = personRepository.findById(id);
//        return ServerResponse
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(personById));
//    }
//
//    @GetMapping(value = "/hello")
//    @ResponseStatus(HttpStatus.OK)
//    public Mono<ServerResponse> findById() {
//        return ServerResponse
//                .ok()
//                .contentType(MediaType.TEXT_PLAIN)
//                .body(BodyInserters.fromValue("Hello, Spring Reactive!"));
//    }
//
//
//
//    //        final Mono<Person> byId = personRepository.findById(id);
////
////        personRepository
////                .delete(person)
////                .subscribe();
//
//
//
//}