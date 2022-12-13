package neostoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neostoxUtility.UtilityNew;

 
 
public class NeoStoxPasswordPage
{
     @FindBy(id = "txt_accesspin")private WebElement passWord;
     
     @FindBy(xpath = "//a[text()='Submit']") private WebElement submitButton;

public NeoStoxPasswordPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void enterpassword(WebDriver driver,String pass) {
 
	UtilityNew.wait(driver, 1000);

	passWord .sendKeys(pass);
	Reporter.log("Entering Number", true);
}
public void ClickOnsubmitButton(WebDriver driver) {
	UtilityNew.wait(driver, 1000);

	submitButton.click(); 
	Reporter.log("Click in submit button", true);
}

}
