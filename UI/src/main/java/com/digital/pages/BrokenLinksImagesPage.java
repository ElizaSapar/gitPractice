package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BrokenLinksImagesPage extends BasePage{

    @FindBy(xpath = "//a[text()='Click Here for Valid Link']")
    public WebElement validLink;
    @FindBy(xpath = "//div[@class='home-content']")
    public WebElement homeDivInSHomePage;
    String targetClass;
    @FindBy(tagName = "h3")
    public WebElement statusCodeText;
    String mainTitle;
    @FindBy(xpath = "//a[text()='Click Here for Broken Link']")
    public WebElement brokenLink;

    public BrokenLinksImagesPage clickToValidLink(){
        elementActions.clickElement(validLink);
        targetClass = homeDivInSHomePage.getAttribute("class");
        elementActions.navigateBack();
        return this;
    }

    public BrokenLinksImagesPage clickToBrokenLink(){
        elementActions.clickElement(brokenLink);
        mainTitle = statusCodeText.getAttribute("innerText");
        elementActions.navigateBack();
        return this;
    }

    public BrokenLinksImagesPage test(){
        Assert.assertEquals(targetClass,"home-content");
        Assert.assertEquals(mainTitle, "Status Codes");
        return this;
    }






}
