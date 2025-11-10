package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BaseTest {

    Logger log = LoggerUtil.getLogger(LoginTest.class);

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return ExcelUtils.getSheetData(
                "src/test/resources/testdata/logindata.xlsx",
                "Sheet1"
        );
    }

    @Test(dataProvider = "loginData", description = "Login with multiple datasets from Excel")
    public void loginTestDDT(String username, String password, String expectedResult) {

        log.info("💡 Starting test with Username: " + username + " | Expected: " + expectedResult);

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        InventoryPage inventoryPage = new InventoryPage();
        boolean isLoggedIn = inventoryPage.isUserLoggedIn();

        if (expectedResult.equalsIgnoreCase("success")) {
            log.info(" Verifying successful login...");
            Assert.assertTrue(isLoggedIn,
                    " Expected login to succeed for: " + username);
            log.info(" Login successful as expected for user: " + username);
        } else {
            log.info(" Verifying login failure...");
            Assert.assertFalse(isLoggedIn,
                    " Expected login to fail for: " + username);
            log.info(" Login failed as expected for user: " + username);
        }
    }
}
