#!/bin/bash


cd spring-blocking-io
./gradlew cleanTest test --warning-mode=none
cd ..