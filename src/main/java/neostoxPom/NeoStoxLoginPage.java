package neostoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostoxUtility.UtilityNew;

 
 
public class NeoStoxLoginPage {

	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement mobilenumfield;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")private WebElement signinButton;
	
	
	public NeoStoxLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void sendMobileNum(WebDriver driver,String mobNum) {
		UtilityNew.wait(driver, 1000);
		mobilenumfield.sendKeys(mobNum);
		Reporter.log("Entering mobileNumber",true);
	}
	public void ClickSigninButton(	WebDriver driver) {
	  
		UtilityNew.wait(driver, 2000);

		signinButton.click();
		Reporter.log("clicking submit button", true);
	}
}
