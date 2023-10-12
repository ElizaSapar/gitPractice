package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ButtonsPage extends BasePage {
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;
    @FindBy(id="rightClickBtn")
    public WebElement rightClickBtn;
    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement simpleCLickBtn;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    public ButtonsPage makeDoubleClick(){
        elementActions.doubleClick(doubleClickBtn);
        return this;
    }
    public ButtonsPage makeRightClick(){
        elementActions.rightClick(rightClickBtn);
        return this;
    }
    public ButtonsPage makeSimpleClick(){
        elementActions.clickElement(simpleCLickBtn);
        return this;
    }

    public ButtonsPage testButtons(){
        Assert.assertEquals(doubleClickBtn.getAttribute("innerText"), "Double Click Me");
        Assert.assertEquals(rightClickBtn.getAttribute("innerText"), "Right Click Me");
        Assert.assertEquals(dynamicClickMessage.getAttribute("innerText"), "You have done a dynamic click");
        return this;
    }

}
