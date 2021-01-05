package com.phptravels.qa.testcases;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.HomePage;
import com.phptravels.qa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homepage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void Setup(){

        initialization();
        loginPage = new LoginPage();
        homepage = loginPage.navigateToHomepage();

    }

    @Test
    public void FlightSearchlinkValidation(){
        homepage.navigateToflightSearchPage();
        WebElement onewayRadio = driver.findElement(By.xpath("//label[text()='One Way']"));
        Assert.assertTrue(onewayRadio.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
