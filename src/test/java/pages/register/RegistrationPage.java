package pages.register;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class RegistrationPage {

    private final By NAME = By.xpath("//input[@name='name']");
    private final By EMAIL = By.xpath("//input[@name='email']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By REGISTER = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");
    private final By LINK_ENTER = By.xpath("//a[contains(text(), 'Войти')]");
    private final By VALIDATE_ERROR = By.xpath("//p[contains(text(), 'User already exists')]");

    public SelenideElement getName () { return element(NAME); }

    public SelenideElement getEmail() { return element(EMAIL); }

    public SelenideElement getPassword () { return element(PASSWORD); }

    public SelenideElement getRegisterButton() {
        return element(REGISTER);
    }

    public SelenideElement getLinkEnter() {
        return element(LINK_ENTER);
    }

    public SelenideElement getValidateError() { return element(VALIDATE_ERROR); }

    public void setName (String name) {
        getName().setValue(name);
    }

    public void setEmail (String email) {
        getEmail().setValue(email);
    }

    public void setPassword (String password) {
        getPassword().setValue(password);
    }
}