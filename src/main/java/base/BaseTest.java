package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.ConfigReader;

import java.io.ByteArrayInputStream;


public class BaseTest {

    @BeforeMethod
    public void setup() {

        // Initialize Driver
        DriverManager.initDriver();

        // Navigate to URL from config.properties
        String url = ConfigReader.getProperty("url");
        DriverManager.getDriver().get(url);

        // Maximize Browser
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        //  Take screenshot only if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment("Failed Test Screenshot",
                    new ByteArrayInputStream(screenshot));
        }

        DriverManager.quitDriver();
    }
}
