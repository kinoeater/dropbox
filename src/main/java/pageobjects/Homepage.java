package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import configandtools.Inputs;
import junit.framework.Assert;

public class Homepage {

	

	//-----WebElements of Home page ----
	
	By hometitle=By.xpath("//h1[@class='page-header__heading']");	
	
	By gotohome=By.xpath("//*[@class='maestro-nav__logo']");
			
	By avatar=By.xpath("//img[@class='mc-avatar-image']");

	By signout=By.xpath("//a[contains(text(),'Sign out')]");
	
	By Settings=By.xpath("//a[contains(text(),'Settings')]");
	
	By ChangePhoto=By.xpath("//button[@class='account-menu-avatar-link']");
	
	By ChangePhotoPopup=By.id("account_photo-upload-button");
	
	By PhotoUploadDone=By.xpath("//span[contains(text(),'Done')]");
	
	
	//--------Side Bar Navigation ----------------
	
	By FilesMenu=By.id("files");
		
	By HomeMenu=By.id("home");
		
	By PaperMenu=By.id("paper");
		
	By ShowCaseMenu=By.id("professional_collections");
		
	By  dropboxtitle=By.xpath("//span[@class='ue-effect-container uee-PathBreadcrumbs-HomeTitle']");
	
	
	
	/*--------Upload objects------------ */
	
	By UploadButton=By.xpath(".//*[text()='Upload']");
	
	By UploadFileButton=By.xpath("//div[@class='mc-popover-content-scroller']//button[1]");
	
	By UploadFolderButton=By.xpath("//div[@class='mc-popover-content-scroller']//button[2]");
	
	By closeInfo=By.xpath(".//*[text()='Close']");
	
	

	
	/*--------New shared folder objects------------ */
	
	By newsharedfolderbutton=By.xpath("//div[@class='ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-new-shared-folder']");
	
	By newsharedfoldersharenew=By.xpath("//div[@class='new-folder_title u-l-ib u-pad-left-xs']");
	
	By newsharedfoldernext=By.xpath("//button[@class='c-btn c-btn--primary']");
		
	By newsharedfoldername=By.id("unified-share-modal-title");
	
	By newsharedfolderemail=By.id("unified-share-modal-contacts-tokenizer");
	
	By newsharedtext=By.xpath("//textarea[@placeholder='Add a message (optional)']");
	
	By newsharedfoldersharebutton=By.xpath("//button[@class='unified-share-modal__share-send c-btn c-btn--primary']");

	By ExistingFolderWarning=By.xpath("//div[@class='u-pad-top-xxs u-pad-bottom-xxs u-pad-left-xs u-pad-right-xs']");
	
		
	/*--------------------------------------------- */
			
	WebDriver driver;
	
	
	//-----Constructor ----
	public Homepage(WebDriver driver){

        this.driver = driver;

           }
	
	

  //-----Go to home page------
    
    public void gotohomepage() {
    	
    	driver.findElement(gotohome).click();
    	
    }
    
    
  //-----Verify Home Page ------

    
    
	
	//-----Go to files menu ------

    public void gotofilesmenu(){

    driver.findElement(FilesMenu).click();
        
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
	
  //-----Method to upload a file from your computer ---
    
    public void UploadFile() throws InterruptedException, AWTException {
    	
    	driver.findElement(UploadButton).click();
		Thread.sleep(3000);
		driver.findElement(UploadFileButton).click();
		Thread.sleep(3000);
		
		Inputs ip=new Inputs(driver);
		String strfilelocation=ip.filelocation;
		
		StringSelection ss = new StringSelection(strfilelocation);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		driver.findElement(closeInfo).click();
    	
    	
    	
    }
    
  //-----Method to change your avatar picture
    
    public void ChangePhoto() throws InterruptedException, AWTException {
    	driver.findElement(avatar).click();
    	Thread.sleep(2000);
    	driver.findElement(ChangePhoto).click();
    	Thread.sleep(2000);
    	driver.findElement(ChangePhotoPopup).click();
    	
    	Thread.sleep(5000);
    	
    	Inputs ip=new Inputs(driver);
		String strfilelocation=ip.profilphotolocation;
		
		StringSelection ss = new StringSelection(strfilelocation);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		
		driver.findElement(PhotoUploadDone).click();
		
    	
    }
 

	
	 //-----Page verifications-----
	public void VerifyHomepage(){

    	String home=driver.findElement(hometitle).getText();
    	Assert.assertEquals("Home", home);

            }
	

    public void VerifyFilespage(){

    	String filesverify=driver.findElement(dropboxtitle).getText();
    	Assert.assertEquals("Dropbox", filesverify);;

            }
    
  
	
    
  //-----Method to navigate in between side bar menu items-----
    
    public void navigatesidebar() throws InterruptedException {
    	
    	driver.findElement(FilesMenu).click();
    	Thread.sleep(3000);
    	VerifyFilespage();
    	gotohomepage();
    	driver.findElement(PaperMenu).click();
    	Thread.sleep(3000);
    	gotohomepage();
    	driver.findElement(ShowCaseMenu).click();
    	Thread.sleep(3000);
    	driver.navigate().back();
    	VerifyHomepage();
    	
    }
    
    	
    	
    }
    

