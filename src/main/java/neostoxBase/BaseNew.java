package neostoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neostoxUtility.UtilityNew;

 
public class BaseNew 
{    protected  static WebDriver driver;
   public void launchbrowser() throws InterruptedException, IOException
   {
	   System.setProperty("webdriver.chrome.driver","C:\\Automation Testing & Manual Testing\\Selenuim  file\\chromedriver.exe"); 
	  driver=new ChromeDriver(); 


      driver.manage().window().maximize();
	
 
	  driver.get(UtilityNew.readDatafromfile("url"));
	 Reporter.log("launch browser", true);
	Thread.sleep(1000);
	
}
}
