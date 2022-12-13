package com.neoStox.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class TradePanelPage {
	
	@FindBy(xpath = "(//span[text()='Hi Avishkar Jadhav '])[1]") private WebElement ProfileName;
	
	@FindBy(xpath = "((//span[@class='righttopmenu1'])[2]//span)[1]") private WebElement AcBalance;
	
	@FindBy(xpath = "//span[text()='My Profile']") private WebElement profileSetting;
	
	@FindBy(xpath = "//input[@id='txt_userfname']") private WebElement FirstName;
	
	@FindBy(xpath = "//input[@id='txt_userlname']") private WebElement LastName;
	
	@FindBy(xpath = "//a[@id='lnk_tradepanel']") private WebElement TradePanel;
	
	public TradePanelPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateProfileName()
	{
		String ActualUserName = ProfileName.getText();
		String ExpectedUserName = "Hi Avishkar Jadhav";
		
		if(ActualUserName.equals(ExpectedUserName))
		{
			System.out.println("Profile is matching TC is passed");
		}
		else 
		{
			System.out.println("Profile is not matching TC is failed");
		}
	}
	public String ActualProfileName(WebDriver driver) throws IOException, InterruptedException {
		String ActualUsername = ProfileName.getText();
		
				
				return ActualUsername;
			}
	
	
	public String ActualACBalance(WebDriver driver) throws IOException, InterruptedException {
		String ActualACBal = AcBalance.getText();
		
		
				return ActualACBal;
			}

	public void clickOnProfileSetting() throws InterruptedException
	{
		Thread.sleep(1000);
		ProfileName.click();
		Thread.sleep(1000);
		profileSetting.click();
	}
	
	public void EnterFirstName(String FName) throws InterruptedException
	{
		Thread.sleep(500);
		FirstName.clear();
		Thread.sleep(500);
		FirstName.click();
		Thread.sleep(500);
		FirstName.sendKeys(FName);
	}
	public void EnterLastName(String LName) throws InterruptedException
	{
		Thread.sleep(500);
		LastName.clear();
		Thread.sleep(500);
		LastName.click();
		Thread.sleep(500);
		LastName.sendKeys(LName);
	}
	public void ClickOnTradePanel() throws InterruptedException
	{
		Thread.sleep(500);
		TradePanel.click();
		Thread.sleep(500);
	}
}
