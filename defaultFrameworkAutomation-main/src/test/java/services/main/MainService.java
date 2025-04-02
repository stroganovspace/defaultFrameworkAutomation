package services.main;

import base.BaseService;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class MainService extends BaseService {

    public void checkEquals() {
        String mainUrl = BASE_URL;

        webdriver().shouldHave(urlContaining(mainUrl.replaceFirst("https?://", "").replaceAll("/$", "")));
    }
}