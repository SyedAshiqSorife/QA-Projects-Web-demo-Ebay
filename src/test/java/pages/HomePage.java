package pages;

import model.Locators;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage (WebDriver driver) { this.driver = driver; }

    public String homePageUrl () {
        return Locators.homePageUrl;
    }

    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }
}
