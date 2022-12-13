package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.neoStox.testCases.Base;
import com.neoStox.utility.Utility;

import net.bytebuddy.utility.RandomString;

public class Listener extends Base implements ITestListener {
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test case "+result.getName()+" is Failed try again", true);
		try {
			String RStr = RandomString.make(4);
			Utility.screenshot(driver, result.getName()+RStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Case "+result.getName()+" is passed ...", true);
		try {
			String RStr = RandomString.make(4);
			Utility.screenshot(driver, result.getName()+RStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Unfortunatly Test case "+result.getName()+" is skipped", true);
	}
	
	
	
}
