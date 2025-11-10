package listeners;

import base.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] takeScreenshot() {
        if (DriverManager.getDriver() == null) {
            return new byte[0];
        }
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Error Details", type = "text/plain")
    public static String attachErrorLog(String message) {
        return message;
    }

    @Override
    public void onTestStart(ITestResult result) {
        Allure.getLifecycle().startStep("STEP-" + System.currentTimeMillis(),
                new io.qameta.allure.model.StepResult()
                        .setName("Starting Test: " + result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.step("Test Passed: " + result.getMethod().getMethodName());
        Allure.getLifecycle().stopStep();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.step("Test Failed: " + result.getMethod().getMethodName());

        // Screenshot + Error Attachment
        takeScreenshot();
        attachErrorLog("Error: " + result.getThrowable().getMessage());

        Allure.getLifecycle().stopStep();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("Test Skipped: " + result.getMethod().getMethodName());
        Allure.getLifecycle().stopStep();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n===== Test Execution Started =====\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n===== Test Execution Finished =====\n");
    }
}
