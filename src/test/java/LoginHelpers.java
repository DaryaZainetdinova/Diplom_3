import PageObjects.AccountProfile;
import PageObjects.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginHelpers {
    static void logout() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickButtomLk();
        AccountProfile accountProfile = page(AccountProfile.class);
        accountProfile.logout();
    }
}
