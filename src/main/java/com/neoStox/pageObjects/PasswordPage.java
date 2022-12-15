package com.neoStox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PasswordPage {
	
	@FindBy(id = "txt_accesspin") private WebElement PassField;
	
	@FindBy(linkText = "Submit") private WebElement SubmitPassBT;

	public PasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterPassword(String Pass) throws InterruptedException
	{
		PassField.click();
		Thread.sleep(1000);
		PassField.sendKeys(Pass);
		Thread.sleep(1000);
		Reporter.log("Passing password", true);
		System.out.println("password");
	}
	
	public void ClickOnSubmitPassword() throws InterruptedException
	{
		Thread.sleep(1000);
		SubmitPassBT.click();
		Thread.sleep(1000);
		Reporter.log("Clicking on submit button", true);
	}
}
