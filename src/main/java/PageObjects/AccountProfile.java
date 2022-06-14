package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountProfile {
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'Modal_modal_opened')]")
    private SelenideElement loaderModal;

    @FindBy(how = How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement buttonProfile;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement buttonLogOut;

    @FindBy(how = How.XPATH, using = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    private SelenideElement text;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement logoBurger;

    public SelenideElement getButtonProfile() {
        return buttonProfile;
    }

    public void logout() {
        this.buttonLogOut.click();
        this.loaderModal.shouldBe(Condition.hidden);
        this.buttonLogOut.shouldBe(Condition.hidden);
    }

    public void clickButtonLogout() {
        buttonLogOut.click();
    }

    public SelenideElement getText() {
        return text;
    }

    public void clickLogoBurger() {
        logoBurger.click();
    }
}
