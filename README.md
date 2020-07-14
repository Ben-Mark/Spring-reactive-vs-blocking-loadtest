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
This repo will demonstrate a Reactive SpringBoot2 java REST server VS Blocking (default) SpringBoot2 java REST server following these metrics:
* 10,000 requests, how long it takes to process in both servers
* 2000 request peak in a second on each server, what will be the average response time, which implementation will overcome that peak
* both servers and couchbase are separated into docker containers, executed via docker swarm, memory & cpu of all containers is customizable 
* both servers will send a CRUD requests to an external couchbase container to see the Non-Blocking I/O shine.
* execution is encapsulated within a run script (no need to learn or master any new underlying technology)


 
<code><i>The blocking spring rest implementation can't even handle a 2k request peak, while the reactive server with the same resources & same database shined , see image #1  </i> </code>



Note: everything in the load-test scenarios are easly customizable, read the custumization seciton below.

-----
## The strength of writing non-blocking code in java
 ![Alt text](results/reactive-2000-request-stress-peak-report.png?raw=true "Title") 

------
#### 10k requests with a concurrency of 100 (thanks to h2load's node engine)
| Reactive   | Blocking  |
|------------|-------------|
| ![Alt text](results/h2load-reactive-10k-requests-with-100threads.png?raw=true "Title") | ![Alt text](results/h2load-blocking-10k-requests-with-100threads.png?raw=true "Title")

------
#### 2000 requests with a concurrency of 2000 (thanks to gatling's scala's engine)

| Reactive   | Blocking  |
|------------|-------------|
| ![Alt text](results/reactive-2000-stress-cli.png?raw=true "Title")  | ![Alt text](results/blocking-2000-stress-cli.png?raw=true "Title")  |  
 
------

#### Spring blocking I/O server failed due to its thread per request/connection threshold 
 ![Alt text](results/spring-blocking-error.png?raw=true "Title") 

------


## Prerequisites
* Docker
* Docker-compose
* jdk 8+
* h2load
* Basic knowledge in what is Blocking I/O & Non-Blocking I/O
* Basic knowledge in reactive programing in Java
* Basic knowledge in scala (to customize gatling load-tests)




## install
* OSX / Linux:   ```source install.sh```
* Windows: ```throw your computer out the window and buy a mac```

## run

##### Throughput loadtests (using h2load - need to install) 
meaning: how much time (in seconds) it takes for each server implementation to handle 10,000 requests
* ```source run/unix/run-reactive-loadtest.sh```
* ```source run/unix/run-blocking-loadtest.sh```


##### Stress tests (using gatling)

* ```./gatling-loadtest/bin/gatling.sh```
    * you will be prompted with 2 options,
        * reactive-stresstest
        * blocking-stresstest
    * then the last prompt of the stress test attempt's name you want in the gatling's graph reports
    * the test run results will be shown in:
        * the CLI
        * 5 different html graphs in ```gatling-loadtest/results/*```


