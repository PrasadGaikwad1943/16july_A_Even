package neostoxUtility;

import java.io.File;
import java.io.FileInputStream;
 import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew {

	 

	public  static String readDatafromfile(String key) throws IOException
	{
		//create object of property class
		
		Properties prop=new Properties();
		
		//create object fileIntpustream and pass property file path as a parameter
		
		FileInputStream myfile=new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\16 jul A Selenuim\\NeoStox.properties");
	
	      prop.load(myfile);
		
		String value = prop.getProperty(key);
        Reporter.log("Reading "+key+" from Property file", true);
         return value;
	}
		 public static void Screshot(WebDriver driver,String screenShotname) throws IOException
		 {    wait(driver,500);
			 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
			 File dest=new File("C:\\Users\\dell\\Desktop\\ScreenShot\\"+screenShotname+".png");
		
			FileHandler.copy(src, dest);
			Reporter.log("Taking ScreenShot",true);
			 }
		 public static void ScrollIntoView(WebDriver driver,WebElement element)
		 {
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView", element);
			 Reporter.log("Scrolling inti views", true);
		 }
		 public static void wait(WebDriver driver ,int waitTime) 
		 {
			 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
			 Reporter.log("waitning for "+waitTime+"millisecond", true);
		 
	}
}
