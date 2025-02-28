package api.Pojo.tests;

import static io.restassured.RestAssured.given;

import api.Pojo.Get.colorData.ColorsData;
import api.Pojo.Get.listUsers.UserData;
import api.Pojo.Post.registrations.Registration;
import api.Pojo.Post.registrations.SuccessRegistration;
import api.Pojo.Post.unRegistration.UnSuccessRegistration;
import api.Pojo.Put.userTime.UserTime;
import api.Pojo.Put.userTime.UserTimeResponse;
import api.Pojo.specifications.Specifications;
import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqrestTest {

  private static final String URL = "https://reqres.in";

  @Test
  public void checkAvatarAndIdTest() {
    Specifications.instalSpecification(Specifications.requestSpec(URL),
        Specifications.responseSpec200());
    List<UserData> users = given()
        .when()
        .get("/api/users?page=2")
        .then().log().all()
        .extract().body().jsonPath().getList("data", UserData.class);

    users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
    Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

    List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
    List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
    List<String> emails = users.stream().map(UserData::getEmail).collect(Collectors.toList());

    for (int i = 0; i < avatars.size(); i++) {
      Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
    }
    for (int i = 0; i < emails.size(); i++) {
      Assert.assertTrue(emails.get(i).endsWith("@reqres.in"));
    }
  }

  @Test
  public void successRegistrationTest() {
    Specifications.instalSpecification(Specifications.requestSpec(URL),
        Specifications.responseSpec200());

    Integer id = 4;
    String token = "QpwL5tke4Pnpja7X4";

    Registration user = new Registration("eve.holt@reqres.in", "pistol");
    SuccessRegistration successRegistration = given()
        .body(user)
        .when()
        .post("/api/register")
        .then().log().all()
        .extract().as(SuccessRegistration.class);

    Assert.assertNotNull(successRegistration.getId());
    Assert.assertNotNull(successRegistration.getToken());

    Assert.assertEquals(id, successRegistration.getId());
    Assert.assertEquals(token, successRegistration.getToken());
  }

  @Test
  public void UnSuccessRegistration() {
    Specifications.instalSpecification(Specifications.requestSpec(URL),
        Specifications.responseError400());

    Registration user = new Registration("eve.holt@reqres.in", "");
    UnSuccessRegistration unSuccessRegistration = given()
        .body(user)
        .when()
        .post("/Pojo/register")
        .then().log().all()
        .extract().as(UnSuccessRegistration.class);

    Assert.assertEquals("Missing password", unSuccessRegistration.getError());
  }

  @Test
  public void sortedYearsTest() {
    Specifications.instalSpecification(Specifications.requestSpec(URL),
        Specifications.responseSpec200());
    List<ColorsData> colorsData = given()
        .when()
        .get("/Pojo/unknown")
        .then().log().all()
        .extract().body().jsonPath().getList("data", ColorsData.class);

    List<Integer> years = colorsData.stream().map(ColorsData::getYear).collect(Collectors.toList());
    List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
    Assert.assertEquals(sortedYears, years);
  }

  @Test
  public void deleteTest() {
    Specifications.instalSpecification(Specifications.requestSpec(URL),
        Specifications.responseUnique(204));
    given()
        .when()
        .delete("/Pojo/users/2")
        .then().log().all();
  }

  @Test
  public void TimeTest() {
    Specifications.instalSpecification(Specifications.requestSpec(URL),
        Specifications.responseUnique(200));
    UserTime user = new UserTime("morpheus", "zion resident");
    UserTimeResponse response = given()
        .body(user)
        .when()
        .put("/Pojo/users/2")
        .then().log().all()
        .extract().as(UserTimeResponse.class);

    String regex = "(.{7})$";
    String regex2 = "(.{13})$";

    String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex2, "");
    Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex, ""));
  }
}