package com.neoStox.testCases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neoStox.pageObjects.HomePage;
import com.neoStox.pageObjects.LogOutFromNeoStox;
import com.neoStox.pageObjects.MobileNoPage;
import com.neoStox.pageObjects.PasswordPage;
import com.neoStox.pageObjects.PopUp2nd;
import com.neoStox.pageObjects.PopUpHandling;
import com.neoStox.pageObjects.TradePanelPage;



public class TC_002 extends Base {
	
	
	
	
	
  @Test
  public void TestMethod() throws IOException, InterruptedException {
	  
	  String ActualProfilename = Tp.ActualProfileName(driver);
		String ExpectedProfileName=(readconfig.getUsername());
		soft.assertEquals(ExpectedProfileName, ActualProfilename);
		Reporter.log("Validating Profile name", true);
		
		String ActualACBal = Tp.ActualACBalance(driver);
		soft.assertNotNull(ActualACBal);
		soft.assertAll();
	  
	  
  }
  
  
}
