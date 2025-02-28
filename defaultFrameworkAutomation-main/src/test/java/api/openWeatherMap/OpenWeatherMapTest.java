package api.openWeatherMap;

import static api.openWeatherMap.Specification.requestSpecification;
import static api.openWeatherMap.Specification.response200;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenWeatherMapTest {

  public static final String URL = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=9f6f05e3424fa81a07a9e7f899091d16&units=imperial";

  @Test
  public void checkCoordTest() {
    Specification.instalSpecification(requestSpecification(URL),
        response200());
    Response response = given()
        .when()
        .get(URL)
        .then().log().all()
        .body("coord.lon", notNullValue())
        .body("coord.lat", notNullValue())
        .extract().response();
    JsonPath jsonPath = response.jsonPath();
    Float lon = jsonPath.get("coord.lon");
    Float lat = jsonPath.get("coord.lat");

    Assert.assertEquals(10.99F, lon);
    Assert.assertEquals(44.34F, lat);
  }

  @Test
  public void checkWeather() {
    Specification.instalSpecification(requestSpecification(URL),
        response200());
    Response response = given()
        .when()
        .get(URL)
        .then().log().all()
        .body("weather.id", notNullValue())
        .body("weather.main", notNullValue())
        .extract().response();
    JsonPath jsonPath = response.jsonPath();
    List<Integer> ids = jsonPath.get("weather.id");
    List<String> mains = jsonPath.get("weather.main");

    assertThat(ids, equalTo(Arrays.asList(600)));
    assertThat(mains, equalTo(Arrays.asList("Snow")));
  }

  @Test
  public void checkTimeZone() {
    Specification.instalSpecification(requestSpecification(URL),
        response200());
    Response response = given()
        .when()
        .get(URL)
        .then().log().all()
        .body("timezone", notNullValue())
        .extract().response();
    JsonPath jsonPath = response.jsonPath();
    Integer timezone = jsonPath.get("timezone");

    Assert.assertEquals(3600, timezone.intValue());
  }
}