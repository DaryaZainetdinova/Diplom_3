package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'Modal_modal_opened')]")
    private SelenideElement loaderModal;

    @FindBy(how = How.XPATH, using = ".//a[text()= 'Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement userEmail;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input")
    private SelenideElement userPassword;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement buttonLogin;

    @FindBy(how = How.XPATH, using = ".//a[text()= 'Восстановить пароль']")
    private SelenideElement buttonResetPassword;

    @FindBy(how = How.XPATH, using = ".//р2[text()= 'Вход']")
    private SelenideElement headerLogin;

    @FindBy(how = How.XPATH, using = ".//p[text()= 'Личный кабинет']")
    private SelenideElement buttonLK;

    public void setUserEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void setUserPassword(String password) {
        userPassword.sendKeys(password);
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    public void login(String email, String password) {
        this.setUserEmail(email);
        this.setUserPassword(password);
        this.clickButtonLogin();

        this.buttonLogin.shouldBe(Condition.hidden);
        this.loaderModal.shouldBe(Condition.hidden);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public SelenideElement getButtonLogin() {
        return buttonLogin;
    }

    public void clickButtonResetPassword() {
        buttonResetPassword.click();
    }

    public void clickButtonLk() {
        buttonLK.click();
    }

    public SelenideElement getHeaderLogin() {
        return headerLogin;
    }
}

