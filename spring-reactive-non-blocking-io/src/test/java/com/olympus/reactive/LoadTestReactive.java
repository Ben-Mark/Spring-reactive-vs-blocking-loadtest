//package com.olympus.reactive;
//
//import com.github.f4b6a3.uuid.UuidCreator;
//import com.github.javafaker.Faker;
//import com.olympus.reactive.couchbase.dto.Person;
//import lombok.extern.log4j.Log4j2;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.mockito.Mockito;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.testng.annotations.Test;
//import org.testng.Assert;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Scheduler;
//import reactor.core.scheduler.Schedulers;
//import reactor.test.StepVerifier;
//
//import java.net.URI;
//import java.util.UUID;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
//import static org.hamcrest.Matchers.equalTo;
//
//
//@Log4j2
//public class LoadTestReactive extends BaseTest {
//
//
//    public static final String BUILDING_1 = "building::1";
//    public static final String COMPANY_2 = "company::2";
////    final Faker faker = new Faker();
//
////    @Test( singleThreaded=true, invocationCount = 1)//dataProvider = "integerProvider")
////    public void test1() throws Exception {
////        webClient.get()
////                .uri("/get-person")
////                .accept(MediaType.TEXT_EVENT_STREAM)
////                .exchange()
////                .expectStatus()
////                .isOk()
////                .returnResult(String.class)
////                .getResponseBody()
////                .subscribe(msg -> {
////                    Assert.assertEquals(msg,"Hello, Spring Reactive!");
////                });
////    }
//
//
//    @Test( singleThreaded=true, invocationCount = 100, threadPoolSize = 8)//dataProvider = "integerProvider")
//    public void testEndpoint() throws Exception {
//        webClient.get()
//                .uri("/test-endpoint")
//                .accept(MediaType.TEXT_PLAIN)
//                .exchange()
//                .expectStatus()
//                .isOk()
//                .expectBody(String.class)
//                .isEqualTo("Person controller: new person was written -> read -> deleted");
//    }
////
////    @Test(singleThreaded=true, invocationCount = 1)
////    public void test2() {
////        webClient.get()
////                .uri(uriBuilder -> uriBuilder
////                        .path( "/get-person")
////                        .queryParam("id", "1757b91f-fd57-4d6e-8847-ce0b334c11ab")
////                        .build())
////                .exchange()
////                .expectStatus()
////                .isOk()
////                .expectBody(Person.class)
////                .value(Person::getFirstName, equalTo("1757b91f-fd57-4d6e-8847-ce0b334c11ab"));
////    }
////
////    @Test( singleThreaded=true, invocationCount = 1000, threadPoolSize = 8)//dataProvider = "integerProvider")
////    public void thousandNonBlockingIoCalls() throws Exception {
////        final String id = UUID.randomUUID().toString();
////
//////        final Person person = new Person(id, faker.name().firstName());
////
////        Mono.just(webClient.get()
////                .uri(uriBuilder -> uriBuilder
////                        .path( "/create-person")
////                        .queryParam("id", id)
////                        .build())
//////                .body(BodyInserters.fromValue(person))//romPublisher(Mono.just(person)), Person.class);
////                .accept(MediaType.TEXT_PLAIN)
////                .exchange()
////                .expectStatus()
////                .isCreated()
////                .expectBody(String.class)
//////                .returnResult();
////                .isEqualTo("Person controller: new person created: "+id))
////
////                .then(Mono.just(webClient.get()
////                        .uri(uriBuilder -> uriBuilder
////                                .path( "/get-person")
////                                .queryParam("id", id)
////                                .build())
////                        .exchange()
////                        .expectStatus()
////                        .isOk()
////                        .expectBody(Person.class)))
//////                        .value(Person::getFirstName, equalTo(person.getFirstName()))))
////
////                .then(Mono.just(webClient.delete()
////                        .uri(uriBuilder -> uriBuilder
////                                .path( "/delete-person")
////                                .queryParam("id", id)
////                                .build())
////                        .exchange()
////                        .expectStatus()
////                        .isOk()
////                        .expectBody(String.class)
////                        .isEqualTo("Person controller: deleted person id: "+id)))
////
////                .subscribe();
////
////
////
////    }
//
//    static final Logger logger = LogManager.getLogger(LoadTestReactive.class.getName());
//
//
//
////    @Test
////    public void tes3() throws InterruptedException {
//////        CountDownLatch latch = new CountDownLatch(1);
//////        final UUID id = UUID.randomUUID();
////
////
////        Flux.range(0,1000)
////                .parallel()
////                .runOn(Schedulers.parallel())
////                .flatMap(i -> {
////                            return client.get()
////                                    .uri("/create-person")
////                                    .accept(MediaType.TEXT_PLAIN)
////                                    .retrieve()
////                                    .bodyToMono(String.class)
////                                    .flatMap(response -> {
//////                                        Assert.assertEquals(response, "Person controller: new person created: " + person.getFirstName());
////                                        return Mono.just(i);
////                                    })
////                                    .then(client.get()
////                                            .uri(uriBuilder -> uriBuilder
////                                                    .path("/get-person")
//////                                                    .queryParam("id", id.toString())
////                                                    .build())
////                                            .retrieve()
////                                            .bodyToMono(Person.class)
////                                            .flatMap(response -> {
//////                                                Assert.assertEquals(response.getFirstName(), person.getFirstName());
////                                                return Mono.just(i);
////                                            }))
////                                    .then(client.delete()
////                                            .uri(uriBuilder -> uriBuilder
////                                                    .path("/delete-person")
//////                                                    .queryParam("id", id.toString())
////                                                    .build())
////                                            .retrieve()
////                                            .bodyToMono(String.class)
////                                            .flatMap(response -> {
//////                                                Assert.assertEquals(response, "Person controller: deleted person id: " + person.getId());
////                                                log.info("Test " + i + " passed successfully");
////                                                return Mono.just(true);
////                                            }));
////                        }
////                )
////                .sequential()
////                .subscribe();
////
//////        latch.await(10, TimeUnit.SECONDS);
////    }
//
//
////    @Test
////    public void shouldSavePerson_findById_thenDeleteIt() {
////        final UUID id = UUID.randomUUID();
////        final Person person = new Person(id, "John");
////        personRepository
////                .save(person)
////                .subscribe();
////
////        final Mono<Person> byId = personRepository.findById(id);
////        StepVerifier
////                .create(byId)
////                .expectNextMatches(result -> result
////                        .getId()
////                        .equals(id))
////                .expectComplete()
////                .verify();
////
////        personRepository
////                .delete(person)
////                .subscribe();
////    }
//
//}