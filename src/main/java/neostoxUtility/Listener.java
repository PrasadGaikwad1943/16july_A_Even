package neostoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neostoxBase.BaseNew;

  
public class Listener extends BaseNew implements ITestListener 
{

	 
	public void onTestFailure(ITestResult result)
	 {     
		  String tcName = result.getName();
		 Reporter.log("TC " +tcName+ "Failed Try Again", true);
	 
		 try {
			UtilityNew.Screshot(driver, tcName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	public void onTestSuccess(ITestResult result) 
	{

		Reporter.log("TC " +result.getName()+ "Success", true);
	}
	 
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("TC " + result.getName()+ "is Skipped check again", true);

}
}
