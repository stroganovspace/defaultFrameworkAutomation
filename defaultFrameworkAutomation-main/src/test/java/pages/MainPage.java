package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class MainPage {

    private final By LINK_BY_PROFILE = By.xpath("//p[contains(text(), 'Aleksei')]");

    public SelenideElement getLinkByProfile() {
        return element(LINK_BY_PROFILE);
    }

}
