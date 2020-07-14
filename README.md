# Overview
About to develop a micro-service in Java? <br>
Concerned about: 
* Blocking I/O?
* maximum throughput (requests per second)?
* want to know what will be your server's threshold?
* Need to show a poc to your boss?
<br>
<br>


You've come to the right place!
<br>
I just saved you <u>months</u> of research inside this repo!
<br>
<br>
This repo will demonstrate a Reactive springboot2 java REST server VS Blocking (default) Springboot2 java REST server following these metrics:
* 10,000 requests, how long it takes to process in both servers
* 2000 request peak in a second on each server, what will be the average response time, which implementation will overcome that peak


Note: everything in the load-test scenarios are easly customizable, read the custumization seciton below.

## The strength of writing non-blocking code in java
* image1
* image2
* image3
 


## Prerequisites
* Docker
* Docker-compose
* jdk 8+
* h2load
* Basic knowledge in what is Blocking I/O & Non-Blocking I/O
* Basic knowledge in reactive programing in Java
* Basic knowledge in scala




## install
* OSX / Linux:   ```source install.sh```
* Windows: ```throw your computer out the window and buy a mac```

## run

##### Throughput loadtests (using h2load - need to install) 
meaning: how much time (in seconds) it takes for each server implementation to handle 10,000 requests
* ```source run/unix/run-reactive-loadtest.sh```
* ```source run/unix/run-blocking-loadtest.sh```


##### Stress tests (using gatling)

* ```~/gatling-loadtest/bin/gatling.sh```
    * you will be prompted with 2 options,
        * reactive-stresstest
        * blocking-stresstest
    * then the last prompt of the stress test attempt's name you want in the gatling reports
    * the test run results will be shown in:
        * the CLI
        * 5 different html graphs in ```gatling-loadtest/results/*```


