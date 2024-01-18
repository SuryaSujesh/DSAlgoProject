package driverFactory;

/*The DriverFactory class is responsible for 
 * initializing the WebDriver instance based on the specified browser type,
 * managing timeouts, and providing access to the WebDriver instance.
*/

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


//Declare the DriverFactory class:

public class DriverFactory {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	//	Define the initialize method:

	public  WebDriver initialize(String browser)throws  Exception  {
		if (browser.equalsIgnoreCase("Chrome")) {
				
			 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			
		}else if (browser.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
		}
		else {
			throw new RuntimeException("BrowserType Not Supported");
		}
		//Setting implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Setting WebDriverWait with max timeout value of 20 seconds
		wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		return driver;
	}
	
	//Define the getdriver method:
		//This method simply returns the WebDriver instance
	public static  WebDriver getdriver() {
		return driver;

	}
	
	//Define the closeallDriver method
		//This method closes the WebDriver instance.
	public void closeallDriver() {
		
		driver.close();
	}
}

	


