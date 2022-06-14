import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegisterPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    @After
    public void cleanup() {
        LoginHelpers.logout();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistrationTest() {
        String salt = RandomStringUtils.randomAlphabetic(6);
        String email = salt + "@mail.kz";
        String password = salt;
        String name = "User " + salt;

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickButtonLogin();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.signup(name, email, password);

        loginPage.login(email, password);
        mainPage.getCreateOrderButton().shouldBe(Condition.visible);
    }
}
