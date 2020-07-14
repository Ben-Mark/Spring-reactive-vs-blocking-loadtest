/*
 * Copyright 2011-2019 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class ReactivePocSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080") // Here is the root for all relative URLs
    .acceptHeader("plain/text") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("utf8")

  val scn = scenario("Reactive-poc loadtest") // A scenario is a chain of requests and pauses
    .exec(
      http("request_1")
        .get("/test-endpoint")
    )
//    .pause(7) // Note that Gatling has recorded real time pauses
//    .exec(
//      http("request_2")
//        .get("/computers?f=macbook")
//    )
//    .pause(2)
//    .exec(
//      http("request_3")
//        .get("/computers/6")
//    )
//    .pause(3)
//    .exec(
//      http("request_4")
//        .get("/")
//    )
//    .pause(2)
//    .exec(
//      http("request_5")
//        .get("/computers?p=1")
//    )
//    .pause(670 milliseconds)
//    .exec(
//      http("request_6")
//        .get("/computers?p=2")
//    )
//    .pause(629 milliseconds)
//    .exec(
//      http("request_7")
//        .get("/computers?p=3")
//    )
//    .pause(734 milliseconds)
//    .exec(
//      http("request_8")
//        .get("/computers?p=4")
//    )
//    .pause(5)
//    .exec(
//      http("request_9")
//        .get("/computers/new")
//    )
//    .pause(1)
//    .exec(
//      http("request_10") // Here's an example of a POST request
//        .post("/computers")
//        .formParam("name", "Beautiful Computer") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
//        .formParam("introduced", "2012-05-30")
//        .formParam("discontinued", "")
//        .formParam("company", "37")
//    )

//  setUp(scn.inject(atOnceUsers(10000)).protocols(httpProtocol))

  setUp(
    scn.inject(rampUsers(5000) during (1 seconds)),
  ).protocols(httpProtocol)
}



//
//================================================================================
//---- Global Information --------------------------------------------------------
//> request count                                      10000 (OK=10000  KO=0     )
//> min response time                                      2 (OK=2      KO=-     )
//> max response time                                     77 (OK=77     KO=-     )
//> mean response time                                     4 (OK=4      KO=-     )
//> std deviation                                          4 (OK=4      KO=-     )
//> response time 50th percentile                          3 (OK=3      KO=-     )
//> response time 75th percentile                          4 (OK=4      KO=-     )
//> response time 95th percentile                          5 (OK=5      KO=-     )
//> response time 99th percentile                         10 (OK=10     KO=-     )
//> mean requests/sec                                243.902 (OK=243.902 KO=-     )
//---- Response Time Distribution ------------------------------------------------
//> t < 800 ms                                         10000 (100%)
//> 800 ms < t < 1200 ms                                   0 (  0%)
//> t > 1200 ms                                            0 (  0%)
//> failed                                                 0 (  0%)
//================================================================================
//
//Reports generated in 0s.
