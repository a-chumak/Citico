package pages;

import com.codeborne.selenide.WebDriverRunner;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static libs.ConfigData.getValue;

public class HomePage extends BasePage{

    public void openHomePage() {
        WebDriverRunner.getAndCheckWebDriver().manage().window().maximize();
        WebDriverRunner.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        open(getValue("PROD"));
    }

    public String getPageTitle() {
        return title();
    }
}