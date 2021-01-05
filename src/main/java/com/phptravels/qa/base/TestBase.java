package com.phptravels.qa.base;

import com.phptravels.qa.util.TestUtil;
import com.phptravels.qa.util.Xls_Reader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static Xls_Reader TestDataXls;


    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/java/com/phptravels/qa/config/config.properties");
            prop.load(ip);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        TestDataXls = new Xls_Reader(System.getProperty("user.dir") +
                "/src/main/java/com/phptravels/qa/xls/TestData.xlsx");


    }

    public static void initialization(){

        String browsername = prop.getProperty("browser");

        if(browsername.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Chrome86/chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }






}
