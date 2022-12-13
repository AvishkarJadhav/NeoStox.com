package com.neoStox.testCases;

import java.io.IOException;


import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.neoStox.pageObjects.HomePage;
import com.neoStox.pageObjects.LogOutFromNeoStox;
import com.neoStox.pageObjects.MobileNoPage;
import com.neoStox.pageObjects.PasswordPage;
import com.neoStox.pageObjects.PopUp2nd;
import com.neoStox.pageObjects.PopUpHandling;
import com.neoStox.pageObjects.TradePanelPage;
import com.neoStox.utility.Utility;



@Listeners(listener.Listener.class)
public class TC_Login_001 extends Base {
	
	
	
	
  @Test
  public void validateProfileNameOfNeoStox() throws InterruptedException, IOException {
	  
	  
	  
	  driver.get(BaseURL);
	  
	  
	  Hp=new HomePage(driver);
	  Hp.ClickOnSignIn();
	  
	  Reporter.log("Click on sign in", true);
	  
	  Mn=new MobileNoPage(driver);
	  
	  Mn.EnterMobileNumber(MoBo);
	  Mn.ClickOnSubmitMObno();
	  
	  Reporter.log("passed mo no", true);
	  
	  Thread.sleep(1000);
	  
	  
	  Pp=new PasswordPage(driver);
	  Pp.EnterPassword(Pass);
	  Reporter.log("Passed Password", true);
	  Pp.ClickOnSubmitPassword();
	  
	  Thread.sleep(5000);
	  
	  Ph=new PopUpHandling(driver);
	  Ph.ClickOnOK();
	  Reporter.log("handled 1st popup", true);
	  
	  Thread.sleep(1000);
	  
	  Ph2=new PopUp2nd(driver);
	  Ph2.ClickOnCloseBT();
	  Reporter.log("handled 2st popup", true);
	  
	  Thread.sleep(1000);
	  
	  Tp=new TradePanelPage(driver);
	  
	  String APN = Tp.ActualProfileName(driver);
	  String EPN = (Utility.readDataFromExcel(13, 2));
	  Assert.assertEquals(APN, EPN);
	  Reporter.log("Validating", true);
	  
	  
	
	 
	  
	  Reporter.log("Validating AC bal", true);
	  
		  
//	  Tp.clickOnProfileSetting();
//	  
//	  Thread.sleep(500);
//	  
//	  Tp.EnterFirstName(FirstName);
//	  Thread.sleep(500);
//	  Tp.EnterLastName(LastName);
//	  
//	  Tp.ClickOnTradePanel();
//	  
	  Thread.sleep(500);
	  Lop=new LogOutFromNeoStox(driver);
	  Lop.ClickOnLogOut();
	  Thread.sleep(1000);
  }
  
 
  
  
}  