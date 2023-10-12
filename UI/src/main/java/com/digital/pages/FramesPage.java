package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends  BasePage{
    @FindBy(id = "frame1")
    public WebElement firstFrame;

    @FindBy(id="frame2")
    public WebElement secondFrame;
    public FramesPage switchToFirstFrame(){
        framesHelper.switchToFrame(firstFrame).returnToDefaultContent();
        return  this;
    }
    public FramesPage switchToSecondFrame(){
        framesHelper.switchToFrame(secondFrame).returnToDefaultContent();
        return  this;
    }


}
