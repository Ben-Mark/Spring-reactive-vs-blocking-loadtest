#!/bin/bash


docker build -t couchbase-1 -f dockers/Dockerfile-couchbase .
#docker tag "$CB_ID" couchbase-1:latest
docker build -t reactive-poc -f dockers/Dockerfile-reactive .
#docker tag "$CB_ID" reactive-poc:latest
docker build -t blocking-poc -f dockers/Dockerfile-blocking .

#env REACTIVE_URI=http://localhost:8080/test-endpoint
#env BLOCKING_URI=http://localhost:8081/test-endpoint
#
#echo "env REACTIVE_URI = $REACTIVE_URI"
#echo "env BLOCKING_URI = $BLOCKING_URI"