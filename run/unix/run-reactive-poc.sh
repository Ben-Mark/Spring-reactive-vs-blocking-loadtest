#!/bin/bash


cd spring-reactive-non-blocking-io
./gradlew cleanTest test --warning-mode=none
cd ..