package com.digital.pages;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WebTables extends BasePage {
    List<String> addedUserInfoList;
    WebDriverWait wait;
    @Test(priority = 1)
    void checUserInTable(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userInTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(  text(),'arslan') ]/parent::div")));
        Assert.assertTrue(userInTable.isDisplayed());
        System.out.println("_______________________");
        List<WebElement> allInfo = driver.findElements(By.xpath("//div[contains(  text(),'arslan') ]/parent::div/child::*"));
        List<String> listUserInfo = new LinkedList<>();
        for  (  WebElement info:allInfo  ){
            listUserInfo.add(info.getText());
        }List<String> cleanedListUserInfo = new LinkedList<>();
        for (WebElement info : allInfo) {
            String text = info.getText().trim();
            if (!text.isEmpty()) {
                cleanedListUserInfo.add(text);
            }
        }
        Set<String> list1 = new HashSet<>(addedUserInfoList);
        Set<String> list2= new HashSet<>(cleanedListUserInfo);
        Assert.assertEquals(list1,list2);

    }

    @Test(priority = 2)
    void checkDeleteBtn(){
        WebElement deleteBtn = driver.findElement(By.id("delete-record-4"));
        deleteBtn.click();
        boolean isUserInTableVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='rt-tbody']//div[contains(text(),'arslan')]")));
        Assert.assertTrue(isUserInTableVisible);
    }








}
