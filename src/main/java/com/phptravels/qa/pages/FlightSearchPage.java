package com.phptravels.qa.pages;

import com.phptravels.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchPage extends TestBase {

    @FindBy(id="s2id_location_from")
    WebElement travelFromField;

    @FindBy(id="s2id_location_to")
    WebElement travelToField;

    @FindBy(xpath="//*[@id=\"flights\"]/div/div/form/div/div/div[3]/div[4]/button")
    WebElement flightSearchButton;

    public FlightSearchPage(){
        PageFactory.initElements(driver,this);
    }


    public FlightSelectPage searchforFlight(){

        travelFromField.click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("Atlanta");
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-results']/li[contains(.,'ATL')]"))).click();

        travelToField.click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("EWR");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-results']/li[contains(.,'EWR')]"))).click();

        flightSearchButton.click();

        return new FlightSelectPage();

    }


}
