package com.olympus.reactive.couchbase;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
@Data
@Configuration
public class CouchbaseProperties {

    private List<String> bootstrapHosts;
    private String bucketName;
    private String bucketPassword;
    private int port;

    public CouchbaseProperties(
            @Value("${spring.couchbase.bootstrap-hosts}") List<String> bootstrapHosts,
            @Value("${spring.couchbase.bucket.name}") String bucketName,
            @Value("${spring.couchbase.bucket.password}") String bucketPassword,
            @Value("${spring.couchbase.port}") int port) {
        this.bootstrapHosts = Collections.unmodifiableList(bootstrapHosts);
        this.bucketName = bucketName;
        this.bucketPassword = bucketPassword;
        this.port = port;
    }

    // getters
}