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

public class FileUploadTest {
	
		/*
	 -- This test will upload a file to your dropbox account.
	 File location should be  written in to Inputs Class under 
	 configandtools package. Sample files can be used which are shared along with the project ---- 
	 
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
		hp.gotofilesmenu();
		hp.UploadFile();
		Thread.sleep(5000);
		lg.Log("The file is uploaded successfully");
		hp.Signout();
		lg.tearDown();
						
	}
	
}
