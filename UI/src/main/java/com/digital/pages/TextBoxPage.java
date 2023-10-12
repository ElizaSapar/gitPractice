package com.digital.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TextBoxPage extends BasePage {
	//Page object model
	@FindBy(id = "userName")
	public WebElement fullNameInput;
	//@FindBy не будет работать без PageFactory
	@FindBy(id = "name")
	public WebElement expectedUserFullName;

	@FindBy(id = "userEmail")
	public WebElement userEmailInput;
	@FindBy(id = "email")
	public WebElement expectedUserEmailInput;
	@FindBy(id = "currentAddress")
	public WebElement currentAddressInput;

	@FindBy(xpath = "//p[@id='currentAddress']")
	public WebElement expectedUserCurrentAddress;

	@FindBy(id = "permanentAddress")
	public WebElement permanentAddressInput;
	@FindBy(xpath = "//p[@id='permanentAddress']")
	public WebElement expectedUserPermanentAddress;
	@FindBy(id = "submit")
	public WebElement submitBtn;

	public TextBoxPage fillUpTheFullName(String fullName) {
		elementActions.writeText(fullNameInput, fullName);
		return this;
	}

	public TextBoxPage fillUpTheEmailName(String emailName) {
		elementActions.writeText(userEmailInput, emailName);
		return this;
	}

	public TextBoxPage fillUpTheCurrentAddress(String currentAddressName) {
		elementActions.writeText(currentAddressInput, currentAddressName);
		return this;
	}

	public TextBoxPage fillUpThePermanentAddress(String permanentAddressName) {
		elementActions.writeText(permanentAddressInput, permanentAddressName);
		return this;
	}

	public TextBoxPage submitForm() {
		elementActions.waitElementToBeClickable(submitBtn)
				.scrollToTheElement(submitBtn)
				.clickElement(submitBtn);
		return this;
	}

	public  TextBoxPage testTexBoxForm(){
		Assert.assertTrue(expectedUserFullName.getText().contains(fullNameInput.getText()));
		Assert.assertTrue(expectedUserEmailInput.getText().contains(userEmailInput.getText()));
		Assert.assertTrue(expectedUserCurrentAddress.getText().contains(currentAddressInput.getText()));
		Assert.assertTrue(expectedUserPermanentAddress.getText().contains(permanentAddressInput.getText()));
		return this;

	}


}
