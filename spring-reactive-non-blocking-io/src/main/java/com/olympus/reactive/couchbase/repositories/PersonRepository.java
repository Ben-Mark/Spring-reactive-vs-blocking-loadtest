package com.olympus.reactive.couchbase.repositories;

import com.olympus.reactive.couchbase.dto.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
//@ViewIndexed(designDoc = ViewPersonRepository.DESIGN_DOCUMENT)
public interface PersonRepository extends ReactiveCrudRepository<Person, UUID> {

    String DESIGN_DOCUMENT = "person";

}