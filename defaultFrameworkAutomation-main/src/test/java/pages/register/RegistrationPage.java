package pages.register;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class RegistrationPage {

    private final By NAME = By.xpath("//input[@name='name']");
    private final By EMAIL = By.xpath("//input[@name='email']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By REGISTER_BUTTON = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");
    private final By LINK_ENTER = By.xpath("//a[contains(text(), 'Войти')]");

    public SelenideElement getName () { return element(NAME); }

    public void setName (String name) {
        getName().setValue(name);
    }

    public SelenideElement getEmail() { return element(EMAIL); }

    public void setEmail (String email) {
        getEmail().setValue(email);
    }

    public SelenideElement getPassword () { return element(PASSWORD); }

    public void setPassword (String password) {
        getPassword().setValue(password);
    }

    public SelenideElement getRegisterButton() {
        return element(REGISTER_BUTTON);
    }

    public SelenideElement getLinkEnter() {
        return element(LINK_ENTER);
    }
}