package com.phptravels.qa.pages;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {

    @FindBy(xpath="//h3[text()='Sign Up']")
    WebElement SignUpPageHeader;

    @FindBy(name="firstname")
    WebElement firstnameField;

    @FindBy(name="lastname")
    WebElement lastnameField;

    @FindBy(name="phone")
    WebElement phoneNumberField;

    @FindBy(name="email")
    WebElement emailIDField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(name="confirmpassword")
    WebElement confirmPasswordField;

    @FindBy(xpath="//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']")
    WebElement signupSubmitButton;

    public SignUpPage(){

        PageFactory.initElements(driver,this);
    }


    public String getSignUpPageHeader(){

        return SignUpPageHeader.getText();
    }

    public MyProfilePage CreateAccount(String fn, String ln, String phonenum, String emailId, String pwd, String confirmpwd){

        firstnameField.sendKeys(fn);
        lastnameField.sendKeys(ln);
        phoneNumberField.sendKeys(phonenum);
        emailIDField.sendKeys(emailId);
        passwordField.sendKeys(pwd);
        confirmPasswordField.sendKeys(confirmpwd);
        
        signupSubmitButton.submit();

        return new MyProfilePage();

    }



}
