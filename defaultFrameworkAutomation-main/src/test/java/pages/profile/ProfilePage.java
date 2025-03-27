package pages.profile;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class ProfilePage {

    private final By NAME = By.xpath("//input[@name='name']");
    private final By EMAIL = By.xpath("//input[@name='email']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By PROFILE_MENU = By.xpath("//a[contains(text(), 'Профиль')]");
    private final By ORDERS = By.xpath("//a[contains(text(), 'История заказов')]");
    private final By EXIT = By.xpath("//button[contains(text(), 'Выход')]");


    public SelenideElement getName() { return element(NAME); }

    public void setName(String name) {
        getName().setValue(name);
    }

    public SelenideElement getEmail() {
        return element(EMAIL);
    }

    public void setEmail(String email) {
        getEmail().setValue(email);
    }

    public SelenideElement getPassword() {
        return element(PASSWORD);
    }

    public void setPassword(String password) {
        getPassword().setValue(password);
    }

    public SelenideElement getProfile_Menu() {
        return element(PROFILE_MENU);
    }

    public SelenideElement getOrders() {
        return element(ORDERS);
    }

    public SelenideElement getExit() {
        return element(EXIT);
    }
}

