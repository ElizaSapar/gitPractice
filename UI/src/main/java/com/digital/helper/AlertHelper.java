package com.digital.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {


    public static final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    private Alert switchToAlert() {

        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = switchToAlert();
        alert.dismiss();
    }


    public void acceptPrompt(String text) {
            Alert alert = switchToAlert();
            alert.sendKeys(text);
            alert.accept();
        }
    }

