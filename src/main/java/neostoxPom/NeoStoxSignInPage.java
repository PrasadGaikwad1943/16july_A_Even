package neostoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostoxUtility.UtilityNew;

 
 
public class NeoStoxSignInPage 
{
	@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement signInButton;
	
	public NeoStoxSignInPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}

	public void ClickOnSignInButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		Reporter.log("Click  on sign in button", true);
		signInButton.click();
	}
}
