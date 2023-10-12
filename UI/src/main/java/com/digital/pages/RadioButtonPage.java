package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RadioButtonPage extends BasePage {
    @FindBy(xpath = "//input[@id='yesRadio']/../label")
    public WebElement yesBtn;


    @FindBy(xpath = "//input[@id='impressiveRadio']/../label")
    public WebElement noBtn;
    @FindBy(xpath = "//input[@id='noRadio']/../label")
    public WebElement noClickBtn;

    public RadioButtonPage clickYesBtn() {
        elementActions.clickElement(yesBtn);
        return this;
    }

    public RadioButtonPage clickNoBtn() {
        elementActions.clickElement(noBtn);
        return this;
    }

    public RadioButtonPage clickNoRadioBtn() {
        elementActions.clickElement(noClickBtn);
        return this;
    }

    public RadioButtonPage testPage() {
        Assert.assertEquals(yesBtn.getAttribute("innerText"), "Yes");
        Assert.assertEquals(noBtn.getAttribute("innerText"), "Impressive");
        Assert.assertTrue(noClickBtn.isEnabled());
        return this;

    }


}
