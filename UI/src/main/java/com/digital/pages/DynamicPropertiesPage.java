package com.digital.pages;
import com.digital.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertiesPage extends BasePage{

	@FindBy(id = "enableAfter")
	public WebElement enableAfterBtn;

	@FindBy(id = "colorChange")
	public WebElement colorChange;

	@FindBy(id="visibleAfter")
	public WebElement visibleAfterBtn;

	JavascriptExecutor js;
	WebDriverWait wait;

	public DynamicPropertiesPage clickAfter(){
		elementActions.waitElementToBeClickable(enableAfterBtn);
		elementActions.clickElement(enableAfterBtn);
		return this;
	}

	public DynamicPropertiesPage clickVisible (){
		elementActions.waitElementToBeVisible(visibleAfterBtn);
		elementActions.clickElement(visibleAfterBtn);
		return this;
	}

	public  DynamicPropertiesPage changeColorBtn(){
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		js = (JavascriptExecutor) Driver.getDriver();
		wait.until(ExpectedConditions.attributeToBe(colorChange, "color", "rgb(220, 53, 69)"));
		js.executeScript("arguments[0].style.backgroundColor = 'white';",colorChange);
		return this;
	}

}
