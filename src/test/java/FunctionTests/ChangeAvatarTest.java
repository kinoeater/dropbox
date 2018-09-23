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
