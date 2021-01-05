package com.phptravels.qa.testcases;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.FlightSearchPage;
import com.phptravels.qa.pages.FlightSelectPage;
import com.phptravels.qa.pages.HomePage;
import com.phptravels.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightSearchPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    FlightSearchPage flightSearchPage;
    FlightSelectPage flightSelectPage;

    public FlightSearchPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();

        loginPage = new LoginPage();
        homePage = loginPage.navigateToHomepage();
        flightSearchPage = homePage.navigateToflightSearchPage();

    }

    @Test
    public void FlightSearchTest(){
        flightSelectPage = flightSearchPage.searchforFlight();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
