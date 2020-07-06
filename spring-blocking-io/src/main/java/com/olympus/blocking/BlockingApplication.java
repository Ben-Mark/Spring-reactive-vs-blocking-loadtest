package com.olympus.blocking;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication(scanBasePackages = "com.olympus.blocking")
@EnableCouchbaseRepositories(basePackages = {"com.olympus.blocking"})
public class BlockingApplication {

    public static void main(String[] args) {
//        Cluster cluster = CouchbaseCluster.create();
//        Bucket bucket = cluster.openBucket("test", "password");
        SpringApplication.run(BlockingApplication.class, args);

    }
}