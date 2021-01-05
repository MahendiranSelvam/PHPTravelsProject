package com.phptravels.qa.pages;

import com.phptravels.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

    @FindBy(xpath="//a[@href='#flights']")
    WebElement flightslink;

    @FindBy(xpath="//a[@href='#hotels']")
    WebElement hotelslink;

    @FindBy(xpath="//a[@href='#boats']")
    WebElement boatslink;

    @FindBy(xpath="//a[@href='#rentals']")
    WebElement rentalslink;

    @FindBy(xpath="//a[@href='#tours']")
    WebElement tourslink;

    @FindBy(xpath="//a[@href='#cars']")
    WebElement carslink;

    @FindBy(xpath="//a[@href='#visa']")
    WebElement visalink;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public FlightSearchPage navigateToflightSearchPage(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(flightslink));

        flightslink.click();
        return new FlightSearchPage();
    }

}
