package com.neoStox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {
	
	@FindBy(linkText = "Sign In") private WebElement SignInBT;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public void ClickOnSignIn() throws InterruptedException
	{
		Thread.sleep(1000);
		SignInBT.click();
		Thread.sleep(1000);
		Reporter.log("Clicking on SignIn ", true);
	}
}
