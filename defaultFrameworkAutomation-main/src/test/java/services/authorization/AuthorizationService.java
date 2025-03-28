package services.authorization;

import base.BaseService;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AuthorizationService extends BaseService {

  public void openAutorizationPage() {
    open(BASE_URL + "/login");
  }
}