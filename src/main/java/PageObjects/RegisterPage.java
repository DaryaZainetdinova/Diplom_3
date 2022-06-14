package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'Modal_modal_opened')]")
    private SelenideElement loaderModal;

    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    private SelenideElement userName;

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement userEmail;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input")
    private SelenideElement userPasswoed;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordError;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement buttonLogin;

    public void setUserName(String name) {
        userName.sendKeys(name);
    }

    public void setUserEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void setUserPassword(String password) {
        userPasswoed.sendKeys(password);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void fillRegistrationForm(String name, String email, String password) {
        this.setUserName(name);
        this.setUserEmail(email);
        this.setUserPassword(password);
    }

    public void signup(String name, String email, String password) {
        this.fillRegistrationForm(name, email, password);
        this.clickRegistrationButton();

        this.loaderModal.shouldBe(Condition.hidden);
        this.registrationButton.shouldBe(Condition.hidden);
    }

    public SelenideElement getIncorrectPasswordError() {
        return incorrectPasswordError;
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }
}
