package com.digital;


import com.digital.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
    }

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Driver.getDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();  // find button alert and click quickly
        Alert alert = Driver.getDriver().switchTo().alert();  // Alert-->interface// we can manage alert only after switching driver into alert interface
        Thread.sleep(5000);
        alert.accept();  // driver should accept some conditions and
        driver.findElement(By.id("timerAlertButton")).click();  // click
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));  // we wait alert appearance
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        alert.dismiss();                          // to deny (we click to "cancel" button

        driver.findElement(By.id("promtButton")).click();
        alert.sendKeys("Nuta");
        alert.accept();
    }

    @Test
    void test12() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");  // to switch from inner frame into out frame and viceversa
        WebElement text = driver.findElement(By.tagName("h1"));
        System.out.println(text.getText());
        driver.switchTo().defaultContent();  // return to the last action
        WebElement div = driver.findElement(By.xpath("//div[@id='framesWrapper']/div"));
        System.out.println(div.getText());

    }

    @Test
    void test13() {
        driver.get("https://demoqa.com/nestedframes");
        //first go to parent frame
        driver.switchTo().frame("frame1");
        // then go to child frame
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        //  Assert.assertEquals(driver.findElement(By.tagName("p")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();  // main interface

    }

//    WebDriver driver;
//    @BeforeClass
//    public  void setIp(){
//        driver = Driver.getDriver();
//    }
//    @Test
//    void  test1() throws InterruptedException {
//        driver.get("https://demoqa.com/alerts");
//        driver.findElement(By.id("alertButton")).click();
//        Alert alert=driver.switchTo().alert();
//        alert.accept();
//        driver.findElement(By.id("timerAlertButton")).click();
//
//        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();
//
//        driver.findElement(By.id("confirmButton")).click();
//        alert.dismiss();
//
//        driver.findElement(By.id("promptButton")).click();
//        alert.sendKeys("Elis");
//        alert.accept();


}