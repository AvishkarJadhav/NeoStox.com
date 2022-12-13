package com.neoStox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PopUpHandling {
	
	@FindBy(xpath =  "(//a[text()='OK'])[2]") private WebElement OkBT;
	

	public PopUpHandling(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickOnOK() throws InterruptedException
	{
		Thread.sleep(1000);
		OkBT.click();
		Reporter.log("Clicking on OK", true);
	}
	
}
