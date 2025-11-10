package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        //  Disable Password Save Popup Completely (Chrome 142+)
        options.addArguments("--disable-features=PasswordManagerOnboarding,PasswordManagerUI,CredentialProviderExtension");
        options.addArguments("--password-store=basic");

        //  Run browser clean every time
        options.addArguments("--incognito");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--no-first-run");

        //  Disable notifications & automation banner
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver.set(new ChromeDriver(options));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
