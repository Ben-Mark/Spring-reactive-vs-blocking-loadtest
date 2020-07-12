#!/bin/bash


docker-compose up -d


ab -n 10000 -c 10 http://localhost:8080/test-endpoint


sleep 10


ab -n 10000 -c 10 http://localhost:8081/test-endpoint


h2load -n 100000 -c50 --h1 http://localhost:8080/test-endpoint
h2load -n 100000 -c50 --h1 http://localhost:8081/test-endpoint