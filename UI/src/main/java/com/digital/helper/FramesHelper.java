package com.digital.helper;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FramesHelper {

    public static final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    public FramesHelper(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }


    public FramesHelper switchToFrame(WebElement element){
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    public FramesHelper returnToDefaultContent(){
        driver.switchTo().defaultContent();
        return this;
    }

    public FramesHelper switchByIndex(int index){
        driver.switchTo().frame(index);
        return this;
    }

    public FramesHelper switchToParentFrame(){
        driver.switchTo().parentFrame();
        return this;
    }




}
