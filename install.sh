#!/bin/bash


docker build -t couchbase-1 -f dockers/Dockerfile-couchbase .
docker build -t reactive-poc -f dockers/Dockerfile-reactive .
docker build -t blocking-poc -f dockers/Dockerfile-blocking .

docker-compose down
docker network prune -f
docker-compose --compatibility up -d


#docker swarm leave -f
#docker network prune -f
#docker swarm init
#docker stack deploy --compose-file docker-compose.yml stack-reactive-poc
