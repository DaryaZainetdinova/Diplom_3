import ApiUsersMethods.CreateUserResponse;
import ApiUsersMethods.User;
import ApiUsersMethods.UserApiClient;
import PageObjects.AccountProfile;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LichnyiKabinetTest {
    UserApiClient userApiClient = new UserApiClient();
    MainPage mainPage;
    User user;
    String email = "Marirna@hgiav.jk";
    String password = "1n11r1111111";
    String name = "Marinchik";
    String accessToken;

    @Before
    public void createUserAndLogin() {
        this.user = new User(email, password, name);
        CreateUserResponse createUserResponse = userApiClient.createUser(this.user).body().as(CreateUserResponse.class);
        this.accessToken = createUserResponse.accessToken;

        this.mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickButtonLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);
    }

    @After
    public void cleanup() {
        LoginHelpers.logout();
        this.userApiClient.deleteUser(this.accessToken);
    }

    @Test
    @DisplayName("Проверка перехода по клику на Личный кабинет")
    public void goToLichnyiKabinetTest(){
        this.mainPage.clickButtomLk();
        AccountProfile accountProfile = page(AccountProfile.class);
        accountProfile.getText().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("переход из личного кабинета в конструктор")
    public void goToConstructorFromLKTest() {
        this.mainPage.clickButtomLk();
        AccountProfile accountProfile = page(AccountProfile.class);
        accountProfile.clickLogoBurger();
        this.mainPage.getTextContainBurger().shouldBe(Condition.visible);
    }
}
