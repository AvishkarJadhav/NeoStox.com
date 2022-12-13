package com.neoStox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutFromNeoStox {
	
	@FindBy(xpath = "//a[@id='lnk_logout']") private WebElement LogoutLink;
	
	@FindBy(xpath = "(//span[text()='Hi Avishkar Jadhav '])[1]") private WebElement ProfileName;
	
	public LogOutFromNeoStox(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickOnLogOut() throws InterruptedException
	{
		Thread.sleep(500);
		ProfileName.click();
		Thread.sleep(1000);
		LogoutLink.click();
	}
}
