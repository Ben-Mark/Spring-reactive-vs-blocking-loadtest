package com.olympus.reactive.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class NewRoute {

    @Bean
    public RouterFunction<?> routerFunction(NewController testController) {
        return route(GET("/test-endpoint"), testController::test);
    }
}