package services.main;

import base.BaseService;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class MainService extends BaseService {

    public void checkUrl() {
        String Url = BASE_URL;

        webdriver().shouldHave(urlContaining(Url.replaceAll("/$", "")));
    }
}
