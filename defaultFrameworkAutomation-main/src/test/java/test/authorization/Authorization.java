package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import services.authorization.AuthorizationService;
import static com.codeborne.selenide.Condition.visible;

public class Authorization {

  private final AuthorizationService authorizationService = new AuthorizationService();
  private final AuthorizationPage authorizationPage = new AuthorizationPage();

  @Test
  public void checkAuthorization() {
    String email = "alex20-03sh@mail.ru";
    String password = "022093Aa";

    authorizationService.openAutorizationPage();
    authorizationPage.setEmail(email);
    authorizationPage.setPassword(password);
    authorizationPage.getEnterButton().click();
  }
}