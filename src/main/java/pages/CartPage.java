package pages;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By checkoutBtn = By.id("checkout");

    public CartPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //  wait added
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn)); //  wait
        driver.findElement(checkoutBtn).click();
    }
}
