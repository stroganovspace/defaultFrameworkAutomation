package services.profile;

import base.BaseService;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProfileService extends BaseService {

    public void checkEqualsUrl() {
        String profileUrl = BaseService.BASE_URL + "/profile";

        webdriver().shouldHave(url(profileUrl));
    }
}
