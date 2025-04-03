package services.authorization;

import base.BaseService;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationService extends BaseService {

  public void openAuthorizationPage() {
    open(BASE_URL + "/login");
  }
}