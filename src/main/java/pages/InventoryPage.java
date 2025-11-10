package pages;

import base.DriverManager;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class InventoryPage {

    private final By title = By.cssSelector(".title");
    private final By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartIcon = By.className("shopping_cart_link");

    public InventoryPage() {
        // No need to pass driver now; we use DriverManager.getDriver()
    }

    public String getPageTitle() {
        return DriverManager.getDriver().findElement(title).getText();
    }

    /**
     * Add Backpack item to cart
     */
    public void addBackpack() {
        DriverManager.getDriver().findElement(addBackpackBtn).click();
    }

    /**
     * Open Cart Page
     */
    public void openCart() {
        DriverManager.getDriver().findElement(cartIcon).click();
    }

    /**
     * Get Cart Item Count (waits until visible)
     */
    public String getCartCount() {
        return WaitUtils.waitElementPresent(
                DriverManager.getDriver(),
                cartBadge,
                10
        ).getText();
    }

    /**
     * Validate user is logged in and reached inventory
     */
    public boolean isUserLoggedIn() {
        return DriverManager.getDriver().getCurrentUrl().contains("inventory.html");
    }
}
