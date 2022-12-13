package com.neoStox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PopUp2nd {
	
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement CloseBT;

	public PopUp2nd(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnCloseBT() throws InterruptedException
	{
		Thread.sleep(500);
		CloseBT.click();
		Thread.sleep(500);
		Reporter.log("Clicking on close button", true);
	}
}
