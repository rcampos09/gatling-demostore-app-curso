package demoStoreApp

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimulationDemoStoreApp extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://demostore.gatling.io")
    .inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg""", """.*detectportal\.firefox\.com.*"""))
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36")

  private val scn = scenario("SimulationDemoStoreApp")
    .exec(
      http("GET - HomePage (1)")
        .get("/")
    )
    .pause(11)
    .exec(
      http("GET - Login")
        .get("/login")
    )
    .pause(11)
    .exec(
      http("POST - Login")
        .post("/login")
        .formParam("_csrf", "3227bdfe-1161-41d5-9053-88a3f3c27339")
        .formParam("username", "user1")
        .formParam("password", "pass")
        .resources(
          http("GET - HomePage (2)")
            .get("/")
        )
    )
    .pause(8)
    .exec(
      http("GET - Category - For-Him")
        .get("/category/for-him")
    )
    .pause(5)
    .exec(
      http("GET - Product (1)")
        .get("/product/casual-black-blue")
    )
    .pause(4)
    .exec(
      http("GET - Add product (1)")
        .get("/cart/add/17")
    )
    .pause(10)
    .exec(
      http("GET - Category - For-Her")
        .get("/category/for-her")
    )
    .pause(5)
    .exec(
      http("GET - Product (2)")
        .get("/product/perfect-pink")
    )
    .pause(6)
    .exec(
      http("GET - Add product (2)")
        .get("/cart/add/26")
    )
    .pause(7)
    .exec(
      http("GET - Cart")
        .get("/cart/view")
    )
    .pause(10)
    .exec(
      http("GET - Confirmation (Product)")
        .get("http://"+ "demostore.gatling.io" + "/cart/checkoutConfirmation")
        .resources(
          http("GET - Checkout")
            .get("/cart/checkout")
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
