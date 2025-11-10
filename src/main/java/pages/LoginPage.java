package pages;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(ThreadLocal<WebDriver> driver) {
    }

    public LoginPage() {

    }

    public void login(String user, String pass) {
        DriverManager.getDriver().findElement(username).sendKeys(user);
        DriverManager.getDriver().findElement(password).sendKeys(pass);
        DriverManager.getDriver().findElement(loginBtn).click();
    }
}
