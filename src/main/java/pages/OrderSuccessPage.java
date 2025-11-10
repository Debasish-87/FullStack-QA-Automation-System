package pages;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage {

    private final WebDriver driver;

    private final By successMsg = By.cssSelector(".complete-header");

    public OrderSuccessPage() {
        this.driver = DriverManager.getDriver();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}
