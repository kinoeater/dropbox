package FunctionTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import configandtools.Inputs;
import pageobjects.SigninPage;
import pageobjects.Homepage;
import configandtools.Tools;
public class NavigateSideMenuTest {
	
	/*
	 -- Login and Logout 
	 
	 */
	
	@Test
	public void navigate() throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		SigninPage sg=new SigninPage (driver);
		Homepage hp=new Homepage(driver);
		Tools lg=new Tools(driver);
		
		sg.Launch();
		sg.LogintoDropbox();
		hp.VerifyHomepage();
		lg.Log("Logged into dropbox successfully");
		hp.navigatesidebar();
		lg.Log("Navigated through the sidebar successfully");
		
		
		hp.Signout();
		lg.tearDown();
		
	}
	
	
	
	

}
