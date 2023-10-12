package com.digital.helper;

import com.digital.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ElementActions {
Actions actions;
public static final int WAIT_TIMEOUT_SECONDS = 10;

    public ElementActions waitElementToBeClickable(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            return this;
        }
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }


    public ElementActions waitElementToBeVisible(WebElement element) {
        if (element.isDisplayed()) {
            return this;
        }
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public ElementActions clickElement(WebElement element) {
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public ElementActions writeText(WebElement element, String txt) {
        waitElementToBeVisible(element);
        element.sendKeys(txt);
        return this;
    }

    public ElementActions hideElementByJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.display='none'", element);
        return this;
    }

    public ElementActions scrollByPixels(int px){
        String script = "window.scrollBy(0, " + px + ");";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);
        return this;
    }



    public ElementActions scrollToTheElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", element);
        return this;
    }

    public ElementActions clickByJS(WebElement element) {
        waitElementToBeVisible(element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public ElementActions clickToRandomElement(List<WebElement> element) {
        int randomIndex = new Random().nextInt(element.size());
        WebElement randomLabel = element.get(randomIndex);
        clickElement(randomLabel);
        return this;
    }


    public ElementActions selectRandomInSelect(WebElement selectList) {
        waitElementToBeVisible(selectList);
        Select select = new Select(selectList);
        List<WebElement> options = select.getOptions();
        int randomIndex = new Random().nextInt(options.size());
        select.selectByIndex(randomIndex);
        return this;
    }

    public ElementActions setTextAndEnterElement(WebElement element, String txt) {
        writeText(element, txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public ElementActions doubleClick(WebElement element){
        actions= new Actions(Driver.getDriver());
        actions.doubleClick(element);
        return this;
    }

    public ElementActions rightClick(WebElement element){
        actions= new Actions(Driver.getDriver());
        actions.contextClick(element);
        return this;
    }

    public ArrayList<String> getAllWindowsHandles(){
        ArrayList<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        return tabs;
    }

    public ElementActions switchToTargetWindow(ArrayList<String> tabs,int index){
        Driver.getDriver().switchTo().window(tabs.get(index));
        return this;
    }
    public void switchToNewTab() {
        LinkedList<String> tabs = new LinkedList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }
    public void switchToPreviousTab(int windowsNum) {
        LinkedList<String> tabs = new LinkedList<>(Driver.getDriver().getWindowHandles());
        if (tabs.size() > 1) {
            Driver.getDriver().switchTo().window(tabs.get(tabs.size() - windowsNum));
        }
    }

    public ElementActions navigateBack(){
        Driver.getDriver().navigate().back();
        return this;
    }


}
