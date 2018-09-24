package FunctionTests;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import configandtools.Inputs;
import configandtools.Tools;
import pageobjects.FilesPage;
import pageobjects.Homepage;
import pageobjects.SigninPage;

public class ChangeAvatarTest {

	/*
	 -- This test will add a new avatar to your dropbox profile.
	  Avatar file should be on your laptop and its location should be written in to Inputs Class 
	  under configandtools package. Avatar pictures can be used which are shared along with the project---- 
	 
	 */
	
	@Test
	public void upfile() throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		
		Inputs ip=new Inputs(driver);
		SigninPage sg=new SigninPage (driver);
		Homepage hp=new Homepage(driver);
		Tools lg=new Tools(driver);
		FilesPage fp=new FilesPage(driver);
		
	
		
		sg.Launch();
		sg.LogintoDropbox();
		hp.VerifyHomepage();
		lg.Log("Logged into dropbox");
		hp.ChangePhoto();
		lg.Log("Avatar changed successfully");
		Thread.sleep(5000);
		hp.Signout();
		lg.tearDown();
		
						
	}
	
}
