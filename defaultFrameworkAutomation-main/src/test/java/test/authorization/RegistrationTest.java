package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import pages.register.RegistrationPage;
import services.authorization.AuthorizationService;
import services.main.MainService;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationTest {
    private final AuthorizationService authorizationService = new AuthorizationService();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final MainService mainService = new MainService();
    private final RegistrationPage registrationPage = new RegistrationPage();


    @Test
    public void checkRegistration() {
        String name = "bfbka";
        String email = "kt@gmail.com";
        String password = "seoy2199";

        authorizationService.openAutorizationPage();
        authorizationPage.getLinkRegister().shouldBe(visible).click();;

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.getRegisterButton().shouldBe(visible).click();

        mainService.checkEquals();
    }
}
