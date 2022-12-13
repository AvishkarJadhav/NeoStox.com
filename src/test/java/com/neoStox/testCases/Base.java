package com.neoStox.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.neoStox.pageObjects.HomePage;
import com.neoStox.pageObjects.LogOutFromNeoStox;
import com.neoStox.pageObjects.MobileNoPage;
import com.neoStox.pageObjects.PasswordPage;
import com.neoStox.pageObjects.PopUp2nd;
import com.neoStox.pageObjects.PopUpHandling;
import com.neoStox.pageObjects.TradePanelPage;
import com.neoStox.utility.ReadConfig;


public class Base {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String BaseURL=readconfig.getApplicationURL();
	public String MoBo=readconfig.getMoNo();
	public String Pass=readconfig.getPass();
	public String FirstName=readconfig.getFirstName();
	public String LastName=readconfig.getLastName();
	public String Username=readconfig.getUsername();
	
	HomePage Hp;
	MobileNoPage Mn;
	PasswordPage Pp;
	PopUpHandling Ph;
	PopUp2nd Ph2;
	TradePanelPage Tp;
	LogOutFromNeoStox Lop;
	
	SoftAssert soft=new SoftAssert();
	
	protected static WebDriver driver;
	public void launchBrowser() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Java\\Selenium\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://neostox.com/sign-in");
	Reporter.log("Launching browser", true);
	Thread.sleep(1000);
	}
	
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(1000);	
	driver.close();
	Thread.sleep(1000);	
	Reporter.log("Closing browser", true);
	Thread.sleep(1000);
	}
	
	public static Logger logger;
	@BeforeClass
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromeDriver());
		driver=new ChromeDriver();
		
		Hp=new HomePage(driver);
		Mn=new MobileNoPage(driver);
		Pp=new PasswordPage(driver);
		Ph=new PopUpHandling(driver);
		Ph2=new PopUp2nd(driver);
		Tp=new TradePanelPage(driver);
		Lop =new LogOutFromNeoStox(driver);
		
		
	}
	
	@BeforeMethod
	public void login2() throws InterruptedException
	{
		driver.get(BaseURL);
		
		Hp.ClickOnSignIn();
		
		
		Mn.EnterMobileNumber(MoBo);
		Mn.ClickOnSubmitMObno();
		
		Thread.sleep(2000);
		Pp.EnterPassword(Pass);
		Pp.ClickOnSubmitPassword();
		
		Thread.sleep(2000);
		Ph.ClickOnOK();
		Thread.sleep(1000);
		
		Ph2.ClickOnCloseBT();
		Thread.sleep(1000);
		
		
	}
	
	@AfterMethod
 	public void LogoutFromNeoStox() throws InterruptedException
 	{
 		Tp=new TradePanelPage(driver);	  
// 		  Tp.clickOnProfileSetting();
// 		  
// 		  Thread.sleep(500);
// 		  
// 		  Tp.EnterFirstName(FirstName);
// 		  Thread.sleep(500);
// 		  Tp.EnterLastName(LastName);
// 		  
// 		  Tp.ClickOnTradePanel();
// 		  
 		  Thread.sleep(500);
 		  Lop=new LogOutFromNeoStox(driver);
 		  Lop.ClickOnLogOut();
 		  Thread.sleep(1000);
 	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
	
	
	

	
}
