package neostoxPom;

 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostoxUtility.UtilityNew;

 
 
public class NeoStoxHomePage
{
     @FindBy(xpath = "(//a[text()='OK'])[2]")private WebElement okButton;
     
     @FindBy (xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;

     @FindBy(id = "lbl_username") private WebElement userName;
     
      @FindBy(id = "lbl_curbalancetop") private WebElement accBalance;
     
     @FindBy(xpath = " //span[text()='Logout']") private WebElement logoutBotton;
     public NeoStoxHomePage(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
     }
     public void handlePopus(WebDriver driver) throws InterruptedException
     { 
    	 if (okButton.isDisplayed()) {
    		 UtilityNew.wait(driver, 1000);
        	 okButton.click();
        	 Reporter.log("Handeling Popup ",true);

        	 Reporter.log("Clicking on the Ok button Popup ",true);
        	 UtilityNew.wait(driver, 2000);
             closeButton.click();
             Reporter.log("Clicking on close Button Popus ", true);	
		}
    	 else
    	 {
    		 Reporter.log(" there is No popup", true);
             Thread.sleep(1000);
    	 
    	 }
    	 
    	 
     }
     public String ActualName(WebDriver driver)
     { 
    	 UtilityNew.wait(driver, 1000);
    	 String actualUserName = userName.getText();
         Reporter.log("getting actual user name",true);
         String realUserName = actualUserName.substring(3);
         Reporter.log("Actual user name is"+ realUserName, true);
    	 return actualUserName;
     }
     public String getAccbalance(WebDriver driver)
     {
    	 UtilityNew.wait(driver, 1000);
   
    	   String accountBalanace = accBalance.getText();
    	   Reporter.log("get in acc balance -:> "+accountBalanace, true);
    	   return accountBalanace;
     }
     public void logout(WebDriver driver)
     {
    	 UtilityNew.wait(driver, 1000);
    	 userName.click();
    	 UtilityNew.wait(driver, 1000);
    	 logoutBotton.click();
    	 Reporter.log("Logging out ", true);
     }
}
