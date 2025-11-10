package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String destPath = "screenshots/" + testName + "_" + timeStamp + ".png";
            File dest = new File(destPath);
            dest.getParentFile().mkdirs();
            Files.copy(Src.toPath(), dest.toPath());
            return destPath;

        } catch (IOException e) {
            System.out.println("Screenshot Failed: " + e.getMessage());
            return null;
        }
    }
}
