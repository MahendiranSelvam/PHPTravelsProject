package com.phptravels.qa.pages;

import com.phptravels.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath="//h3[text()='Login']")
    WebElement loginPageHeader;

    @FindBy(xpath="//a[text()='Home']")
    WebElement homeLink;

    @FindBy(name="username")
    WebElement usernameField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='btn btn-success br25 btn-block form-group']")
    WebElement signUpButton;

    public LoginPage(){

        PageFactory.initElements(driver,this);
    }

    public String getLoginPageHeader(){

        return loginPageHeader.getText();
    }


    public MyProfilePage Login(String un, String pwd){

        usernameField.sendKeys(un);
        passwordField.sendKeys(pwd);
        loginButton.submit();

        return new MyProfilePage();
    }

    public SignUpPage ClickSignUpButton(){

        signUpButton.click();
        return new SignUpPage();
    }

    public HomePage navigateToHomepage(){

        homeLink.click();
        return new HomePage();

    }


}
