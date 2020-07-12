package com.olympus.reactive.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.github.javafaker.Faker;
import com.olympus.reactive.couchbase.dto.Person;
import com.olympus.reactive.couchbase.repositories.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class NewController {

    private final PersonRepository personRepository;

    final Faker faker = new Faker();

    public NewController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


//    public Mono<ServerResponse> ping(ServerRequest serverRequest) {
//        return ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue("{\n" +
//                        "  \"status\": \"ok\"\n" +
//                        "}");
//    }

    public Mono<ServerResponse> test(ServerRequest serverRequest){
        //non-blocking uuid generator
        UUID id = UuidCreator.getRandomBased();
        final Person person = new Person(id, "ben" );//faker.name().firstName());
//        log.info("new request , generated person id: "+id);

        return Mono.when(personRepository.save(person))
                .flatMap(then -> personRepository.findById(id))
                .flatMap(then -> personRepository.deleteById(id))
                .flatMap(then-> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue("Person controller: new person was written -> read -> deleted"));
// Mono.just("Person controller: new person was written -> read -> deleted"));
    }

}