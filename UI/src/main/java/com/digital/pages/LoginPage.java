package com.digital.pages;

import com.digital.driver.Driver;
import com.digital.models.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    @FindBy(id="newUser")
    public WebElement createUserBtn;

    @FindBy(id="firstname")
    public WebElement firstNameInput;


    @FindBy(id="lastname")
    public WebElement lastNameInput;


    @FindBy(id="userName")
    public WebElement loginInput;

    @FindBy(id="password")
    public WebElement passwordInput;


    @FindBy (xpath = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
    public WebElement recaptchaFrame;
    @FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
    public  WebElement recaptchaInput;

    @FindBy(id="recaptcha-verify-button")
    public  WebElement recBtn;

    @FindBy(xpath = "//ifame[@title='recaptcha challenge expires in two minutes']")
    public WebElement frame;
    public LoginPage clickToRecaptcha() throws InterruptedException {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
     elementActions.clickByJS(recaptchaInput);
Thread.sleep(5);
Driver.getDriver().switchTo().defaultContent();
        Thread.sleep(5);
     new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']")));
        Thread.sleep(10);
     elementActions.clickElement(recBtn);
        Thread.sleep(10);
        elementActions.clickElement(recBtn);
        return this;
    }


    public LoginPage clickToCreateUser(){
        elementActions.clickElement(createUserBtn);
        return this;
    }

    public LoginPage fillUpTheFirstNameInput(String txt){
        elementActions.writeText(firstNameInput, txt);
        return this;
    }
    public LoginPage fillUpTheLastNameInput(String txt){
        elementActions.writeText(lastNameInput, txt);
        return this;
    }
    public LoginPage fillUpTheLoginInput(String txt){
        elementActions.writeText(loginInput, txt);
        return this;
    }
    public LoginPage fillUpThePasswordInput(String txt){
        elementActions.writeText(passwordInput, txt);
        passwordInput.sendKeys(Keys.ENTER);
        return this;
    }


    public LoginPage fillUpTheForm(Person person){
        clickToCreateUser()
                .fillUpTheFirstNameInput(person.getFirstName())
                .fillUpTheLastNameInput(person.getLastName())
                .fillUpTheLoginInput(person.getLogin());
//                .fillUpThePasswordInput(person.getPassword()).clickToRecaptcha();
        return this;

    }



}
