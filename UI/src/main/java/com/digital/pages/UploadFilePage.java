package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UploadFilePage  extends BasePage{
    @FindBy(id = "uploadFile")
    public WebElement uploadFileInput;

    @FindBy(id="uploadedFilePath")
    public WebElement uploadFilePathText;

    public UploadFilePage clickToUploadInput(){
        elementActions.writeText(uploadFileInput,"C:\\Users\\Asus\\Pictures\\141e4ba7106d6ccfee8eeed68944836f.jpg");
        return this;
    }

    public UploadFilePage test(){
        Assert.assertEquals(uploadFilePathText.getAttribute("innerText"), "C:\\fakepath\\141e4ba7106d6ccfee8eeed68944836f.jpg");
        return this;
    }

}
