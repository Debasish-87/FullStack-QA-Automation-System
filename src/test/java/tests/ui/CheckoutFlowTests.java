package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.OrderSuccessPage;

public class CheckoutFlowTests extends BaseTest {

    @Test(description = "Complete Checkout Flow E2E")
    public void completeCheckoutFlowTest() {

        // 1. Login
        new LoginPage().login("standard_user", "secret_sauce");

        // 2. Add item to cart
        InventoryPage inv = new InventoryPage();
        inv.addBackpack();
        inv.openCart();

        // 3. Cart Page → Checkout
        CartPage cart = new CartPage();
        cart.clickCheckout();

        // 4. Enter Checkout Information
        CheckoutInfoPage info = new CheckoutInfoPage();
        info.fillInfo("John", "Doe", "12345");
        info.continueCheckout();

        // 5. Checkout Overview
        CheckoutOverviewPage overview = new CheckoutOverviewPage();
        Assert.assertTrue(overview.isOnOverviewPage(), "Not on Overview Page!");

        // Finish Checkout (This was missing!)
        overview.finishCheckout();

        // 6. Verify Order Success
        OrderSuccessPage success = new OrderSuccessPage();
        Assert.assertEquals(success.getSuccessMessage(), "Thank you for your order!");
    }
}
