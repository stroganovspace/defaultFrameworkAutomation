package test.authorization;

import base.TestDataGenerator;
import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import pages.register.RegistrationPage;
import services.authorization.AuthorizationService;
import services.main.MainService;
import services.registration.RegistrationService;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationTest {
    private final AuthorizationService authorizationService = new AuthorizationService();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final MainService mainService = new MainService();
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final TestDataGenerator testDataGenerator = new TestDataGenerator();

    @Test
    public void checkRegistration() {
        String name = testDataGenerator.generateName();
        String email = testDataGenerator.generateEmail();
        String password = testDataGenerator.generatePassword();

        authorizationService.openAutorizationPage();
        authorizationPage.getLinkRegister().shouldBe(visible.because("Ссылка на страницу регистрации не отображается")).click();

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.getRegisterButton().shouldBe(visible.because("Кнопка входа должна отображаться")).click();

        mainService.checkUrl();
    }
}
