package tests;

import base.BaseTests;
import model.CommonMethods;
import model.Locators;
import model.Timout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class SearchProducts {
    BaseTests baseTests = new BaseTests();
    WebDriver driver = baseTests.setUp();
    Timout timeout = new Timout();
    CommonMethods commonMethods = new CommonMethods(driver);
    HomePage homePage = new HomePage(driver);

    @BeforeClass
    public void setUp () {
        driver.manage().window().maximize();
        driver.get(homePage.homePageUrl());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        timeout.timeout();
        commonMethods.clickOnButton(Locators.signIn);
        timeout.timeout();
        commonMethods.back();
    }

    //search from searchBox
    @Test(priority = 1)
    public void searchFromSearchBoxTest () {
        timeout.timeout();
        commonMethods.clickOnButton(Locators.searchBox);
        timeout.timeout();
        commonMethods.sendText(Locators.searchBox, "Mobile");
        timeout.timeout();
        commonMethods.clickOnButton(Locators.searchBtn);
    }

    //Select from categories
    @Test (priority = 2)
    public void selectFromCategory () {
        commonMethods.back();
        timeout.timeout();
        commonMethods.clickOnButton(Locators.categories);
        timeout.timeout();
        commonMethods.clickOnButton(Locators.categoryNameHealthAndBeauty);
    }

    @AfterClass
    public void tearDown() {
        timeout.timeout();
        driver.quit();
    }
}
