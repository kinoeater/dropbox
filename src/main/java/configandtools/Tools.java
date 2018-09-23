package configandtools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class Tools {

WebDriver driver;
	
	//-----Constructor ----
	public Tools(WebDriver driver){

        this.driver = driver;

           }

	public void Log(String message) {
		Reporter.log(message, true);
	}
	
	
	
	
	
	public void tearDown(){
		
		Log("Closing Webdriver, end of the test");
		
		driver.close();
	
}
	
}
