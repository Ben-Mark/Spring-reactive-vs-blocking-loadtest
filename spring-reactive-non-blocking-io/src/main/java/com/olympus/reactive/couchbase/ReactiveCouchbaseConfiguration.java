package com.olympus.reactive.couchbase;

//import com.couchbase.client.java.env.CouchbaseEnvironment;
//import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
//import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

import java.util.List;

@Configuration
@EnableReactiveCouchbaseRepositories("com.baeldung.couchbase.domain.repository")
public class ReactiveCouchbaseConfiguration extends AbstractCouchbaseConfiguration {
 
    private final CouchbaseProperties couchbaseProperties;
 
    public ReactiveCouchbaseConfiguration(CouchbaseProperties couchbaseProperties) {
        this.couchbaseProperties = couchbaseProperties;
    }

//    @Override
//    public String getConnectionString() {
//        return couchbaseProperties.getBootstrapHosts();
//    }

//    @Override
//    public String getUserName() {
//        return couchbaseProperties.getBucketName();
//    }

//    @Override
//    public String getPassword() {
//        return couchbaseProperties.getBucketPassword();
//    }

    @Override
    protected List<String> getBootstrapHosts() {
        return couchbaseProperties.getBootstrapHosts();
    }

    @Override
    public String getBucketName() {
        return couchbaseProperties.getBucketName();
    }

    @Override
    protected String getBucketPassword() {
        return couchbaseProperties.getBucketPassword();
    }

//    @Override
//    protected List<String> getBootstrapHosts() {
//        return couchbaseProperties.getBootstrapHosts();
//    }
//
//    @Override
//    protected String getBucketName() {
//        return couchbaseProperties.getBucketName();
//    }
//
//    @Override
//    protected String getBucketPassword() {
//        return couchbaseProperties.getBucketPassword();
//    }
//
//    @Override
//    public CouchbaseEnvironment couchbaseEnvironment() {
//        return DefaultCouchbaseEnvironment
//          .builder()
//          .bootstrapHttpDirectPort(couchbaseProperties.getPort())
//          .build();
//    }
}