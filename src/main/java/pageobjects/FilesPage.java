package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class FilesPage {

	

	//-----WebElements of Files page ----
	
	By files=By.id("files");
	By  dropboxtitle=By.xpath("//span[@class='ue-effect-container uee-PathBreadcrumbs-HomeTitle']");
	
	
	/*-------Create folder objects ------------*/
	
	By upload=By.xpath(".//*[text()='Upload']");
	
	By newfolder=By.xpath(".//*[text()='New folder']");

	By newfoldername=By.cssSelector(".c-input");
	
	By newfoldericon=By.xpath(".//*[contains(@id,'component')]/div/div[2]/main/div[2]/div/div[1]/div[2]/div/ul/li[2]/button");
	
	By closeupdinfo=By.xpath(".//*[text()='Close']");
	
	By uploadfile=By.xpath("//div[@class='mc-popover-content-scroller']//button[1]");
	
	/*--------Home page and sign out objects------------ */
	
	By gotohome=By.xpath("//*[@class='maestro-nav__logo']");
		
	By hometitle=By.xpath("//h1[@class='page-header__heading']");	
	
	By avatar=By.xpath("//img[@class='mc-avatar-image']");

	By signout=By.xpath("//a[contains(text(),'Sign out')]");
	
	/*--------New shared folder objects------------ */
	
	By newsharedfolderbutton=By.xpath("//div[@class='ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-new-shared-folder']");
	
	By newsharedfoldersharenew=By.xpath("//div[@class='new-folder_title u-l-ib u-pad-left-xs']");
	
	By newsharedfoldernext=By.xpath("//button[@class='c-btn c-btn--primary']");
		
	By newsharedfoldername=By.id("unified-share-modal-title");
	
	By newsharedfolderemail=By.id("unified-share-modal-contacts-tokenizer");
	
	By newsharedtext=By.xpath("//textarea[@placeholder='Add a message (optional)']");
	
	By newsharedfoldersharebutton=By.xpath("//button[@class='unified-share-modal__share-send c-btn c-btn--primary']");

	By ExistingFolderWarning=By.xpath("//div[@class='u-pad-top-xxs u-pad-bottom-xxs u-pad-left-xs u-pad-right-xs']");
		
	
	
	WebDriver driver;
	
	
	//-----Constructor ----
	public FilesPage(WebDriver driver){

        this.driver = driver;

           }
	
//-----go to home page------
    
    public void gotohomepage() {
    	
    	driver.findElement(gotohome).click();
    	
    }
    
    
  //-----Verify Files Page ------

    public void VerifyFilespage(){

    	String filesverify=driver.findElement(dropboxtitle).getText();
    	Assert.assertEquals("Dropbox", filesverify);;

            }
   
  //-----Verify Home Page ------

    public void VerifyHomepage(){

    	String home=driver.findElement(hometitle).getText();
    	Assert.assertEquals("Home", home);;

            }
	
	//-----go to files menu ------

    public void gotofilesmenu(){

    driver.findElement(files).click();
        
    }
	
        
	//-----Sign out  ------

    public void Signout(){

    driver.findElement(avatar).click();
    driver.findElement(signout).click();
        
    }
		     
  
  //-----Method to create a new folder and share it with someone, if the folder name you use already exists, it adds "1" to the end of your entry ------

    public void sharenewfolder(String foldername,String emailtoshare, String note) throws InterruptedException{

    	driver.findElement(gotohome).click();
    	VerifyHomepage();
    	driver.findElement(newsharedfolderbutton).click();
		driver.findElement(newsharedfoldersharenew).click();
		driver.findElement(newsharedfoldernext).click();
		driver.findElement(newsharedfoldername).sendKeys(foldername);
		driver.findElement(newsharedfolderemail).sendKeys(emailtoshare);
		driver.findElement(newsharedtext).sendKeys(note);
		driver.findElement(newsharedfoldersharebutton).click();
		
		int countexistng=driver.findElements(ExistingFolderWarning).size();
//		System.out.println(countexistng);
		
		while(countexistng>0)
		{
			driver.findElement(newsharedfoldername).click();
			Thread.sleep(1000);
			driver.findElement(newsharedfoldername).sendKeys("1");
			Thread.sleep(1000);
			driver.findElement(newsharedfoldersharebutton).click();
			countexistng=driver.findElements(ExistingFolderWarning).size();
				}
		
					
			
    }
        
    /*----------------Create Normal Folder--------*/
	
    
    public void CreateNewFolder(String strnewfoldername) {
    	
    	driver.findElement(newfolder).click();
    	driver.findElement(newfoldername).sendKeys(strnewfoldername);
    	
    	
    }
    
    
    /*----------------Rename One of the  Folders--------
    public void renameFolder(String folderName,String renamedFolderName) throws Exception{

		if(!fileIsPresent(folderName, true)){
			createFolder(folderName);
		}
		driver.findElement(By.xpath("//li[@data-filename='"+folderName+"']")).click();
		renameButton.click();
		WebDriverUtilities.waitForElement(driver, renameFolderName);
		renameFolderName.clear();
		renameFolderName.sendKeys(renamedFolderName);
		renameFolderName.sendKeys("\n");
		WebDriverUtilities.waitForElement(driver, notificationMsg);
		Assert.assertTrue(fileIsPresent(renamedFolderName, true)); */


	
    
    
}

