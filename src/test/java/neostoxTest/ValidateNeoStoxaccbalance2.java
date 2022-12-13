package neostoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neostoxBase.BaseNew;
import neostoxPom.NeoStoxHomePage;
import neostoxPom.NeoStoxLoginPage;
import neostoxPom.NeoStoxPasswordPage;
import neostoxPom.NeoStoxSignInPage;
import neostoxUtility.UtilityNew;

 

 
@Listeners(neostoxUtility.Listener.class)
public class ValidateNeoStoxaccbalance2 extends BaseNew
{
	 NeoStoxLoginPage login;
	 NeoStoxPasswordPage password;
	 NeoStoxHomePage homepage;
	 NeoStoxSignInPage signin;
	@BeforeClass
	public void launchNeostox() throws InterruptedException, IOException
	{
		launchbrowser();//from base class
		
		login=new NeoStoxLoginPage(driver);
		
		Thread.sleep(1000);
		
		password=new NeoStoxPasswordPage(driver);
	    
		homepage=new NeoStoxHomePage(driver);
	   
		signin=new NeoStoxSignInPage(driver);
	}
	@BeforeMethod
public void logintoNeostox() throws EncryptedDocumentException, IOException, InterruptedException {
	    signin.ClickOnSignInButton(driver);
	   
	    Thread.sleep(1000);
		
	    login.sendMobileNum(driver, UtilityNew.readDatafromfile("mobnumber"));
		
	    login.ClickSigninButton(driver);
		
	    UtilityNew.wait(driver, 1000);
		
	    password.enterpassword(driver,  UtilityNew.readDatafromfile("password"));
     
	    Thread.sleep(1000);
	
	    password.ClickOnsubmitButton(driver);
		
	    Thread.sleep(3000);
		
	    homepage.handlePopus(driver);
		
	}
	
	
	 @Test
	 public void Accountbalance() throws IOException, InterruptedException
	 { 
		 
		 Thread.sleep(1000);
		
		 Assert.assertNotNull(homepage.getAccbalance(driver),"TC failed not read acc balance");
       
		 UtilityNew.Screshot(driver, "Account balance -:");
	   
		  
		   Assert.fail();
		   Thread.sleep(1000);
	 }
	@Test (priority = -1)
	public void validateuserID() throws EncryptedDocumentException, IOException {
	  
		
		Assert.assertEquals(homepage.ActualName(driver), UtilityNew.readDatafromfile("userName"),"TC is failed actual and expected user Name are not matching");
		
		 
		UtilityNew.Screshot(driver,homepage.ActualName(driver) );
	  	
	}
	@AfterMethod
	public void logoutfromneoStox()
	{
		homepage.logout(driver);
		
	} 
	@AfterClass
	public void closebrowser()
	{
		Reporter.log("closing browser", true);
		driver.close();
	}
}
