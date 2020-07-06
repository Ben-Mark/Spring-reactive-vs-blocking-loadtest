package com.olympus.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController
{

//    @PostMapping(value = { "/create", "/" })
//    @ResponseStatus(HttpStatus.CREATED)
//    public void create(@RequestBody Employee e) {
//        employeeService.create(e);
//    }

    @GetMapping(value = "/hello")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ServerResponse> findById() {
//        Mono<Employee> e = employeeService.findById(id);
//        HttpStatus status = (e != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
//         new ResponseEntity<>(e, status);

        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring Reactive!"));
    }

//    @GetMapping(value = "/name/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public Flux<Employee> findByName(@PathVariable("name") String name) {
//        return employeeService.findByName(name);
//    }
//
//    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public Flux<Employee> findAll() {
//        return employeeService.findAll();
//    }
//
//    @PutMapping(value = "/update")
//    @ResponseStatus(HttpStatus.OK)
//    public Mono<Employee> update(@RequestBody Employee e) {
//        return employeeService.update(e);
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void delete(@PathVariable("id") Integer id) {
//        employeeService.delete(id).subscribe();
//    }
}