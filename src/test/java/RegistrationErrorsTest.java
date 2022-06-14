import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegisterPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationErrorsTest {
    @Test
    @DisplayName("тест на ошибку в воде пароля(неккоректный пароль)")
    public void registrationFailed() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickButtomLk();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.fillRegistrationForm("Dahjkjs78", "8993784@jhl.dj", "78h");
        registerPage.clickRegistrationButton();
        registerPage.getIncorrectPasswordError().shouldBe(Condition.visible);
    }
}
