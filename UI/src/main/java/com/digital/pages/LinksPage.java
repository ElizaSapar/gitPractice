package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;

public class LinksPage extends BasePage {
    @FindBy(id = "simpleLink")
    public WebElement homeLink;

    @FindBy(id = "dynamicLink")
    public WebElement dynamicLink;

    @FindBy(id = "created")
    public WebElement createdBtn;
    @FindBy(id = "no-content")
    public WebElement noContentBtn;
    @FindBy(id = "moved")
    public WebElement movedBtn;

    @FindBy(id = "bad-request")
    public WebElement badRequestBtn;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedBtn;

    @FindBy(id = "invalid-url")
    public WebElement invalidBtn;
    @FindBy(id = "forbidden")
    public WebElement forbiddenBtn;
    @FindBy(xpath = "//div[@class='home-content']")
    public WebElement homeDivInSHomePage;
    //////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//p[@id='linkResponse']//b[text()='Created']")
    public WebElement createdText;
    @FindBy(xpath = "//p[@id='linkResponse']//b[text()='No Content']")
    public WebElement noContentText;
    @FindBy(xpath = "//p[@id='linkResponse']//b[text()='Moved Permanently']")
    public WebElement movedText;
    @FindBy(xpath = "//p[@id='linkResponse']//b[text()='Bad Request']")
    public WebElement badRequestText;
    @FindBy(xpath = "//p[@id='linkResponse']//b[text()='Unauthorized']")
    public WebElement unauthorizedText;
    @FindBy(xpath = "//p[@id='linkResponse']//b[text()='Forbidden']")
    public WebElement forbiddenText;
    @FindBy(xpath = "//p[@id='linkResponse']//b[text()='Not Found']")
    public WebElement notFoundText;
    String targetClass;
    String targetClass2;

    ///////////////////////////////////////////////////////////////////////////////
    public LinksPage clickToHomeLink() {
        elementActions.clickElement(homeLink);
        ArrayList<String> tabs = elementActions.getAllWindowsHandles();
        elementActions.switchToTargetWindow(tabs, 1);
        targetClass = homeDivInSHomePage.getAttribute("class");
        elementActions.switchToTargetWindow(tabs, 0);
        return this;
    }

    public LinksPage clickToDynamicLink() {
        elementActions.clickElement(dynamicLink);
        ArrayList<String> tabs = elementActions.getAllWindowsHandles();
        elementActions.switchToTargetWindow(tabs, 1);
        targetClass2 = homeDivInSHomePage.getAttribute("class");
        elementActions.switchToTargetWindow(tabs, 0);
        return this;
    }

    public LinksPage clickToCreateResponseBtn() {
        elementActions.clickElement(createdBtn);
        elementActions.waitElementToBeVisible(createdText);
        Assert.assertEquals(createdText.getAttribute("innerText"), "Created");
        return this;
    }

    public LinksPage clickToNoContentResponseBtn() {
        elementActions.clickElement(noContentBtn);
        Assert.assertEquals(noContentText.getAttribute("innerText"), "No Content");
        return this;
    }

    public LinksPage clickToMovedResponseBtn() {
        elementActions.clickElement(movedBtn);
        Assert.assertEquals(movedText.getAttribute("innerText"), "Moved Permanently");
        return this;
    }

    public LinksPage clickToBadRequestBtn() {
        elementActions.clickElement(badRequestBtn);
        Assert.assertEquals(badRequestText.getAttribute("innerText"), "Bad Request");
        return this;
    }

    public LinksPage clickToUnauthorizedBtn() {
        elementActions.clickElement(unauthorizedBtn);
        Assert.assertEquals(unauthorizedText.getAttribute("innerText"), "Unauthorized");
        return this;
    }

    public LinksPage clickToForbiddenBtn() {
        elementActions.clickElement(forbiddenBtn);
        Assert.assertEquals(forbiddenText.getAttribute("innerText"), "Forbidden");
        return this;
    }

    public LinksPage clickToInvalidBtn() {
        elementActions.clickElement(invalidBtn);
        Assert.assertEquals(notFoundText.getAttribute("innerText"), "Not Found");
        return this;
    }


    public LinksPage test() {
        Assert.assertEquals(targetClass, "home-content");
        Assert.assertEquals(targetClass2, "home-content");
        return this;
    }

}
