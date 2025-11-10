package pages;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CheckoutOverviewPage {

    private WebDriver driver = DriverManager.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By overviewTitle = By.cssSelector(".title");
    private By finishBtn = By.id("finish");

    public boolean isOnOverviewPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(overviewTitle))
                .getText().equals("Checkout: Overview");
    }

    public void finishCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }
}
