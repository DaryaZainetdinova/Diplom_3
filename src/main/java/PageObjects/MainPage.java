package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement buttonLogIn;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement buttonLK;

    @FindBy(how = How.XPATH, using = ".//a[text()= 'Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(how = How.CLASS_NAME, using = "Modal_modal_opened__3ISw4 Modal_modal__P3_V5")
    private SelenideElement loaderModal;

    @FindBy(how = How.XPATH, using = ".//button[text()= 'Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = ".//h1[text()= 'Соберите бургер']")
    private SelenideElement textContainBurger;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab')]/span[text()='Булки']")
    private SelenideElement constructorTabBun;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab')]/span[text()='Соусы']")
    private SelenideElement constructorTabSouse;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab')]/span[text()='Начинки']")
    private SelenideElement constructorTabFilling;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab') and contains(@class, 'current')]")
    private SelenideElement constructorActiveTab;

    public void clickButtonLogin() {
        buttonLogIn.click();
    }

    public void clickButtomLk() {
        buttonLK.click();
    }

    public void clickRegistrationButton(){
        registrationButton.click();
    }

    public void waitForLoad() {
        loaderModal.shouldBe(Condition.hidden);
    }

    public SelenideElement getCreateOrderButton() {
        return createOrderButton;
    }
    public SelenideElement getTextContainBurger () {
        return textContainBurger;
    }

    public void clickConstructorBunTab() {
        constructorTabBun.click();
    }

    public void clickConstructorSouseTab() {
        constructorTabSouse.click();
    }

    public void clickConstructorFillingTab() {
        constructorTabFilling.click();
    }

    public String getActiveConstructorTabName() {
        return constructorActiveTab.getText();
    }
}
