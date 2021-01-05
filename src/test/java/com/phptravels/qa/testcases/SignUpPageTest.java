package com.phptravels.qa.testcases;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.LoginPage;
import com.phptravels.qa.pages.SignUpPage;
import com.phptravels.qa.util.TestUtil;
import com.phptravels.qa.util.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpPageTest extends TestBase {

    LoginPage loginPage;
    SignUpPage signUpPage;

    public SignUpPageTest(){
        super();
    }

    @BeforeMethod
    public void Setup(){
        initialization();
        loginPage = new LoginPage();
        signUpPage = loginPage.ClickSignUpButton();

    }

    @Test(priority = 1)
    public void HeaderVerificationTest(){
        Assert.assertEquals(signUpPage.getSignUpPageHeader(),"Sign Up");
    }

    @Test(priority = 2, dataProvider = "SignUpTestData")
    public void CreateAccountTest(String FN, String LN, String phonenum, String email, String pwd, String Confirmpwd){
        signUpPage.CreateAccount(FN,LN,phonenum,email,pwd,Confirmpwd);
    }

    @DataProvider
    public Object[][] SignUpTestData(){

        String TestDataSheet = "SignUpTest";

        Object[][] TestData;

        TestData = TestUtil.getData(TestDataXls, TestDataSheet);
        return  TestData;

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
