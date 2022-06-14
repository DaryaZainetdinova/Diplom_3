import ApiUsersMethods.CreateUserResponse;
import ApiUsersMethods.User;
import ApiUsersMethods.UserApiClient;
import PageObjects.*;
import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {
    UserApiClient userApiClient = new UserApiClient();
    MainPage mainPage;
    User user;
    String email = "tesmaill@hj.kz";
    String password = "rt897j874";
    String name = "vitalwik";
    String accessToken;

    @Before
    public void createUser() {
        this.user = new User(email, password, name);
        Response response = this.userApiClient.createUser(this.user);
        CreateUserResponse res = response.body().as(CreateUserResponse.class);
        this.accessToken = res.accessToken;

        this.mainPage = open(MainPage.URL, MainPage.class);
    }

    @After
    public void cleanUp() {
        LoginHelpers.logout();
        userApiClient.deleteUser(this.accessToken);
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginByButtonLogin() {
        this.mainPage.clickButtonLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);
        this.mainPage.getCreateOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет")
    public void loginByLk() {
        this.mainPage.clickButtomLk();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);
        this.mainPage.getCreateOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginByPasswordResetButtonTest() {
        this.mainPage.clickButtomLk();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickButtonResetPassword();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.clickButtonLogin();
        loginPage.login(email, password);
        this.mainPage.getCreateOrderButton().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginByRegisterFormTest() {
        this.mainPage.clickButtomLk();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickButtonLogin();
        loginPage.login(email, password);
        this.mainPage.getCreateOrderButton().shouldBe(Condition.visible);
    }
}
