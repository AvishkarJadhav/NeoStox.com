package com.neoStox.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neoStox.pageObjects.HomePage;
import com.neoStox.pageObjects.LogOutFromNeoStox;
import com.neoStox.pageObjects.MobileNoPage;
import com.neoStox.pageObjects.PasswordPage;
import com.neoStox.pageObjects.PopUp2nd;
import com.neoStox.pageObjects.PopUpHandling;
import com.neoStox.pageObjects.TradePanelPage;
import com.neoStox.utility.Utility;

public class TC_003 extends Base {
	


	
		HomePage Hp;
		MobileNoPage Mn;
		PasswordPage Pp;
		PopUpHandling Ph1;
		PopUp2nd Ph2;
		TradePanelPage Tp;
		LogOutFromNeoStox Lop;
		SoftAssert soft;
		
		@BeforeClass
		public void LaunchNeoStox() throws InterruptedException
		{
			launchBrowser();
			Hp=new HomePage(driver);
			Mn= new MobileNoPage(driver);
			Pp=new PasswordPage(driver);
			Ph1=new PopUpHandling(driver);
			Ph2=new PopUp2nd(driver);
			Tp=new TradePanelPage(driver);
			Lop=new LogOutFromNeoStox(driver);	
			soft=new SoftAssert();
			
		}
		
		@BeforeMethod
		public void LogintoNeoStox() throws EncryptedDocumentException, InterruptedException, IOException
		{
			Thread.sleep(1000);
			Hp.ClickOnSignIn();
			Thread.sleep(1000);
			Mn.EnterMobileNumber(Utility.readDataFromExcel(13, 0));
			Thread.sleep(1000);
			Mn.ClickOnSubmitMObno();
			Thread.sleep(1000);
			Pp.EnterPassword(Utility.readDataFromExcel(13, 1));
			Thread.sleep(1000);
			Pp.ClickOnSubmitPassword();
			
			
		}
		
		@Test
		  public void ValidateProfileName() throws IOException, InterruptedException {
				
			Thread.sleep(1000);
			Ph1.ClickOnOK();
			Thread.sleep(1000);
			Ph2.ClickOnCloseBT();
			Thread.sleep(1000);
				String ActualProfilename = Tp.ActualProfileName(driver);
				String ExpectedProfileName=(Utility.readDataFromExcel(13, 2));
				Assert.assertEquals(ExpectedProfileName, ActualProfilename);
				Reporter.log("Validating Profile name", true);
		  }
		@Test(priority = 1)
	  public void ValidateACBal() throws IOException, InterruptedException {
			Thread.sleep(1000);
			String ActualACbalance = Tp.ActualACBalance(driver);
			Assert.assertNotNull(ActualACbalance);
			Reporter.log("Validating AC balance", true);
	  }
		
		
		@AfterMethod
		public void LogOutfromNeoStox() throws InterruptedException
		{
			Lop.ClickOnLogOut();
		}
		
		@AfterClass
		public void closeBrowser() throws InterruptedException
		{
			CloseBrowser();
		}
		
		
	
  
}
