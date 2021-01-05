package com.phptravels.qa.testcases;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.LoginPage;
import com.phptravels.qa.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginpage;
    SignUpPage signUpPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void SetUp(){
        initialization();
        loginpage = new LoginPage();
    }

    @Test
    public void HeaderVerificationTest(){

        Assert.assertEquals(loginpage.getLoginPageHeader(),"Login");

    }

    @Test
    public void SignUpButtonTest(){
         signUpPage = loginpage.ClickSignUpButton();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
