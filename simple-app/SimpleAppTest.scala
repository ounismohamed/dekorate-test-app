package nouvelair

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._



class SimpleAppTest extends Simulation {
    
    // Via Gateway
    val httpProtocol = http.baseUrl("http://127.0.0.1/")

 val apiUrl = "/"

//****************************************************** Get popularServices *************************************************************//

  val scngetPopularServices = scenario("Page d'acceuil") // A scenario is a chain of requests and pauses
      
      .exec(http("Wave1").get(apiUrl))
      .pause(5)




//****************************************************************************************************************************************/


val users=10

  setUp(
    
    scngetPopularServices.inject(atOnceUsers(users)).protocols(httpProtocol)

  )

}
