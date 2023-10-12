package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage{

   @FindBy(id = "alertButton")
   public WebElement toSeeAlertBtn;
   @FindBy(id="timerAlertButton")
   public  WebElement timeAlertBtn;

   @FindBy(id="confirmButton")
   public  WebElement confirmBtn;

   @FindBy(id="promtButton")
   public  WebElement promtBtn;

   public AlertsPage clickBtnToSeeAlert(){
      elementActions.clickElement(toSeeAlertBtn);
       alertHelper.acceptAlert();
      return this;
   }
   public AlertsPage clickWithTimer(){
      elementActions.clickElement(timeAlertBtn);
      alertHelper.acceptAlert();
      return this;
   }

   public AlertsPage clickToConfirm(){
      elementActions.clickElement(confirmBtn);
      alertHelper.acceptAlert();
      return this;
   }

   public AlertsPage clickToWriteInPromt(String txt){
      elementActions.clickElement(promtBtn);
      alertHelper.acceptPrompt(txt);
      return this;
   }


}
