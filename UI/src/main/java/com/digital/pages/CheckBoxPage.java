package com.digital.pages;

import com.digital.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CheckBoxPage extends BasePage {
	JavascriptExecutor js;
	@FindBy(xpath = "//button[@title='Toggle']")
	WebElement toogleBtnInHome;
	@FindBy(xpath = "//button[@title='Toggle']/following::button")
	List<WebElement> toggleOtherbtns;
	@FindBy(xpath = "//span[text() = 'Documents']/parent::label/parent::span/../ol//button")
	List<WebElement> btnInDocuments;
	@FindBy(xpath = "//span[@class='rct-checkbox']")
	List<WebElement> listOfCheckoxInputs;
	@FindBy(xpath = "//span[@class='text-success']")
	List<WebElement> listOfPackageTitle;


	public CheckBoxPage openAllPackage() {
		elementActions.waitElementToBeClickable(toogleBtnInHome);
		elementActions.clickElement(toogleBtnInHome);
		clickAllElements(toggleOtherbtns);
		clickAllElements(btnInDocuments);
		return this;
	}

	private void clickAllElements(List<WebElement> elements) {
		js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scrollBy(0,500);");
		for (WebElement el : elements) {
			elementActions.waitElementToBeVisible(el);
			elementActions.clickElement(el);
		}
	}

	public CheckBoxPage selectedCheckbox() {
		for (int i = listOfCheckoxInputs.size() - 1; i >= 0; i--) {
			elementActions.clickElement(listOfCheckoxInputs.get(i));
		}
		return this;
	}

	public CheckBoxPage testCheckBoxTitle(String[] titleTxt) {

		for (int i = 0; i < titleTxt.length; i++) {
			Assert.assertEquals(titleTxt[i], listOfPackageTitle.get(i).getText().trim());
		}
		return this;

	}


}