package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;


public class AuthorizationPage {

  private final By EMAIL = By.xpath("//input[@name='email']");
  private final By PASSWORD = By.xpath("//input[@name='password']");
  private final By ENTER_BUTTON = By.xpath("//button[contains(text(), 'Войти')]");
  private final By LINK_REGISTER = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");
  private final By LINK_FORGOT_PASSWORD = By.xpath("//a[contains(text(), 'Восстановить пароль')]");

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

  public SelenideElement getEnterButton() {
    return element(ENTER_BUTTON);
  }

  public SelenideElement getLinkRegister() {
    return element(LINK_REGISTER);
  }

  public SelenideElement getLinkForgotPassword() {
    return element(LINK_FORGOT_PASSWORD);
  }
}