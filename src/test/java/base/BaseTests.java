package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    WebDriver driver;

    public WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        return driver;
    }
}
