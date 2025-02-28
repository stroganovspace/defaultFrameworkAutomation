package api.openWeatherMap;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

  public static RequestSpecification requestSpecification(String URL) {
    return new RequestSpecBuilder()
        .setBaseUri(URL)
        .setContentType(ContentType.JSON)
        .build();
  }

  public static ResponseSpecification response200() {
    return new ResponseSpecBuilder()
        .expectStatusCode(200)
        .build();
  }

  public static void instalSpecification(RequestSpecification request,
      ResponseSpecification response) {
    RestAssured.requestSpecification = request;
    RestAssured.responseSpecification = response;
  }
}