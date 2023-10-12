package com.digital.helper;

import com.digital.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CustomScreenShotMethods {

    private WebDriver driver;

    public CustomScreenShotMethods() {
        this.driver = Driver.getDriver();
    }

    public void takeScreenShot() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File scrFile = screenshot.getScreenshotAs(OutputType.FILE);

            String dateTime = getCurrentDateTime();
            String screenshotName = "screenshot" + dateTime + ".png";
            System.out.println(dateTime + "  " + screenshotName);

            File screenshotDirectory = new File("Screenshots");
            if (!screenshotDirectory.exists()) {
                screenshotDirectory.mkdirs();
            }

            String screenshotPath = screenshotDirectory.getAbsolutePath() + File.separator + screenshotName;
            FileUtils.copyFile(scrFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH);
        return LocalDateTime.now().format(formatter);
    }
}
