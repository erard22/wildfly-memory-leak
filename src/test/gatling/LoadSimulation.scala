import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoadSimulation extends Simulation {

  val httpConf = http.baseUrl(System.getProperty("gatling.base.url", "http://localhost:8080/wildfly-memory-leak/hello-world/"))

  val headers = Map("Content-Type" -> "application/json", "Accept" -> "application/json", "timeToLiveInSeconds" -> "30")


  val scn =
    scenario("Simulation")
      .exec(
        http("GET HelloWorld")
          .get("/hello")
          .headers(headers)
          .body(StringBody("Hello World!"))
          .check(status is 200)
      )
      .inject(
        constantUsersPerSec(20) during(1 minutes)
      )

  setUp(scn)
    .protocols(httpConf)
    .maxDuration(1 minute)
    .assertions(
      //global.responseTime.mean.lt(30),
      global.successfulRequests.percent.is(100)
    )
}
