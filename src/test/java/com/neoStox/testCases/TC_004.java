package com.neoStox.testCases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(listener.Listener.class)
public class TC_004 extends Base {
  @Test
  public void ValidateProfileName() throws IOException, InterruptedException {
	  
	  String ActualProfilename = Tp.ActualProfileName(driver);
		String ExpectedProfileName=(readconfig.getUsername());
		
		soft.assertEquals(ExpectedProfileName, ActualProfilename);
		Reporter.log("Validating Profile name", true);
		
		String ActualACBal = Tp.ActualACBalance(driver);
		soft.assertNotNull(ActualACBal);
		soft.assertAll();
  }
}
