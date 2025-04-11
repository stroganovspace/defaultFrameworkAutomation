package services.registration;

import base.BaseService;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RegistrationService extends BaseService {

    public void checkEqualsUrl() {
        webdriver().shouldHave(url(BaseService.BASE_URL + "/register"));
    }
}


