package tests;

import base.BaseTests;
import model.CommonMethods;
import model.Locators;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import model.Timout;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class HomePageTest {
    BaseTests baseTests = new BaseTests();
    WebDriver driver = baseTests.setUp();
    Timout timeout = new Timout();
    CommonMethods commonMethods = new CommonMethods(driver);
    HomePage homePage = new HomePage(driver);

    @BeforeClass
    public void setUp () {
        driver.get(homePage.homePageUrl());
        timeout.timeout();
        driver.manage().window().maximize();
        timeout.timeout();
        commonMethods.clickOnButton(Locators.signIn);
        timeout.timeout();
        commonMethods.back();
    }

    @Test
    public void homePageTest() {
        timeout.timeout();
        String title = commonMethods.getTitle();
        assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
    }

    @AfterClass
    public void tearDown() {
        timeout.timeout();
        driver.quit();
    }
}
