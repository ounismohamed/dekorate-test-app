package simpleapp

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._



class SimpleAppTest extends Simulation {
    
    // Via Gateway
    val httpProtocol = http.baseURL("http://127.0.0.1:8080")

 val apiUrl = "/persons"

//****************************************************** Get popularServices *************************************************************//

  val scngetPopularServices = scenario("Page d'acceuil") // A scenario is a chain of requests and pauses
      
      .exec(http("Wave1").get(apiUrl))
      .pause(5)




//****************************************************************************************************************************************/


val users=102

  setUp(
    
    scngetPopularServices.inject(atOnceUsers(users)).protocols(httpProtocol)

  )

}
