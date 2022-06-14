import PageObjects.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    MainPage mainPage;

    @Before
    public void prepare() {
        this.mainPage = open(MainPage.URL, MainPage.class);
        this.mainPage.waitForLoad();
    }

    @Test
    public void checkSouseTabIsClickable() {
        this.mainPage.clickConstructorSouseTab();
        String activeTab = this.mainPage.getActiveConstructorTabName();
        Assert.assertEquals(activeTab, "Соусы");
    }

    @Test
    public void checkFillingTabIsClickable() {
        this.mainPage.clickConstructorFillingTab();
        String activeTab = this.mainPage.getActiveConstructorTabName();
        Assert.assertEquals(activeTab, "Начинки");
    }

    @Test
    public void checkBunTabIsClickable() {
        this.mainPage.clickConstructorFillingTab();
        this.mainPage.clickConstructorBunTab();
        String activeTab = this.mainPage.getActiveConstructorTabName();
        Assert.assertEquals(activeTab, "Булки");
    }
}
