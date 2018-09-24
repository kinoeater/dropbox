package FunctionTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import configandtools.Inputs;
import configandtools.Tools;
import pageobjects.Homepage;
import pageobjects.SigninPage;

public class ShareFolderTest {

	/*
	 -- This test will create  a new folder then share it with someone.
	  Folder name and email address are parameterized.They should be  written in to Inputs Class 
	  under configandtools package. Sample files can be used which are shared along with the project---- 
	 
	 */
	
	
	@Test
	public void ShareFolder() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		Inputs cr=new Inputs(driver);
		SigninPage sg=new SigninPage (driver);
		Homepage hp=new Homepage(driver);
		Tools lg=new Tools(driver);
		
		String strsharedfoldername=cr.SharedFolderNm;
		String stremailtoshare= cr.EmailThatYouShareFolder;
		String note=cr.NoteforSharedFolder;
		
		sg.Launch();
		sg.LogintoDropbox();
		hp.VerifyHomepage();
		lg.Log("Logged into dropbox");
		hp.sharenewfolder(strsharedfoldername, stremailtoshare, note);
		Thread.sleep(3000);
		lg.Log("The folder "+ strsharedfoldername + " is shared successfully with "+ stremailtoshare);
		hp.gotohomepage();
		hp.Signout();
		lg.tearDown();
						
	}
	
}
