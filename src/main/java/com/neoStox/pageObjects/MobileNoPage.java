package com.neoStox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MobileNoPage {
	
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement MobileNoField;
	
	@FindBy(xpath = "//a[@id='lnk_signup1']") private WebElement SubmitMOBNO;
	
	public MobileNoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void EnterMobileNumber(String MobNo) throws InterruptedException
	{
		Thread.sleep(100);
		MobileNoField.click();
		Thread.sleep(100);
		MobileNoField.sendKeys(MobNo);
		Reporter.log("Passing Mo No", true);
	}
	
	public void ClickOnSubmitMObno() throws InterruptedException
	{
		
		
		System.out.println("Clicking on submit BT");
		
		
		Thread.sleep(1000);
		SubmitMOBNO.click();
		Thread.sleep(1000);
		Reporter.log("Clicking on submit button", true);
	}
}
