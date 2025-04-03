package test.authorization;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.authorization.AuthorizationPage;
import services.authorization.AuthorizationService;
import services.profile.ProfileService;

import static com.codeborne.selenide.Condition.visible;

public class AuthorizationTest {
  private final AuthorizationService authorizationService = new AuthorizationService();
  private final AuthorizationPage authorizationPage = new AuthorizationPage();
  private final ProfileService profileService = new ProfileService();
  private final MainPage mainPage = new MainPage();

  @Test
  public void checkAuthorization() {
    String email = "alex20-03sh@mail.ru";
    String password = "12345678";

    authorizationService.openAutorizationPage();
    authorizationPage.setEmail(email);
    authorizationPage.setPassword(password);
    authorizationPage.getEnterButton().click();

    mainPage.getLinkByProfile().shouldBe(visible).click();

    profileService.checkEqualsUrl();
  }
}

