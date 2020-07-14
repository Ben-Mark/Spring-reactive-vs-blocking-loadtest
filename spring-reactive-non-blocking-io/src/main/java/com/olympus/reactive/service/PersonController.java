package com.olympus.reactive.service;

import com.github.f4b6a3.uuid.UuidCreator;

import com.olympus.reactive.couchbase.dto.Person;
import com.olympus.reactive.couchbase.repositories.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Log4j2
@Component
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Mono<ServerResponse> reactiveEndpoint(ServerRequest serverRequest){
        //non-blocking uuid generator
        final UUID id = UuidCreator.getRandomBased();
        final Person person = new Person(id, "person name");
        log.info("new request , generated person id: "+id);

        return Mono.when(personRepository.save(person))
                .flatMap(res -> personRepository.findById(id))
                .flatMap(res -> personRepository.deleteById(id))
                .flatMap(res -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue("Person controller: new person was written -> read -> deleted"));
    }

}