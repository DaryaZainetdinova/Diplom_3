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

public class LogOutTest {
    UserApiClient userApiClient = new UserApiClient();
    String email = "hjhj@ghg.kz";
    String password = "rt897j874";
    String name = "zpplover";
    String accessToken;

    @Before
    public void createUser() {
        User user = new User(email, password, name);
        CreateUserResponse createUserResponse = userApiClient.createUser(user).body().as(CreateUserResponse.class);
        this.accessToken = createUserResponse.accessToken;

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickButtonLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);
    }

    @After
    public void cleanup() {
        this.userApiClient.deleteUser(this.accessToken);
    }

    @Test
    @DisplayName("logOut по кнопке ВЫХОД в ЛК")
    public void logOutFromLK() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickButtomLk();
        AccountProfile accountProfile = page(AccountProfile.class);
        accountProfile.clickButtonLogout();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.getButtonLogin().shouldBe(Condition.enabled);
        mainPage.getCreateOrderButton().shouldBe(Condition.hidden);
    }
}
