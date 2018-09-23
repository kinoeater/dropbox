package FunctionTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import configandtools.Inputs;
import configandtools.Tools;
import pageobjects.FilesPage;
import pageobjects.Homepage;
import pageobjects.SigninPage;

public class CreateNewFolderTest {

	
	@Test
	public void Create_N_Folder() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		Inputs ip=new Inputs(driver);
		SigninPage sg=new SigninPage (driver);
		Homepage hp=new Homepage(driver);
		Tools lg=new Tools(driver);
		FilesPage fp=new FilesPage(driver);
		
		
		String strnewfoldername=ip.NewFolderName;
	
		
		sg.Launch();
		sg.LogintoDropbox();
		hp.VerifyHomepage();
		lg.Log("Logged into dropbox");
		hp.gotofilesmenu();
		fp.CreateNewFolder(strnewfoldername);
		Thread.sleep(5000);
		lg.Log("New folder created successfully");
		hp.Signout();
		lg.tearDown();
						
	}
	
}
