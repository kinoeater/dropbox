package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configandtools.Inputs;
import configandtools.Tools;
public class SigninPage {

	
	
	/*
	 --Used Page Object Method, where By class is used.
	 --There is also Page Factory Method, where FindBy Class is used.
	 --Page Factory Method also works in similar fashion with a few slight difference.
	 
	 */
	
	

	
	
	//-----WebElements of Sign In page ----
	
	By signupine=By.id("sign-up-in");
	
	By username=By.name("login_email");
	
	By password=By.name("login_password");
	
	By rememberme=By.xpath("//div[@class='checkbox small remember-me checkbox-inline']");
	
	By loginbutton=By.xpath("//div[@class='signin-text']");

	WebDriver driver;
	
	
	//-----Constructor ----
	public SigninPage(WebDriver driver){

        this.driver = driver;

           }
	
	
	//-----Launch the page------
	
	public void Launch() {
		driver.get(Inputs.MAIN_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	
	 public void filluserandpwd() {
	    	
		 	Inputs ip=new Inputs(driver);
	    	String strUserName=ip.LOGIN_USER;
			String strPassword=ip.LOGIN_PWD;
			
			driver.findElement(username).sendKeys(strUserName);
	    	driver.findElement(password).sendKeys(strPassword);
			
	    	
	    }
	
	
	//-----Choose to sign in ------
    
    public void gotosignin() {
    	
    	driver.findElement(signupine).click();
    	
    }
    
    
           
	//-----Login Method ------
	

    public void LogintoDropbox(){

    	
    	gotosignin();
    	filluserandpwd();
    	driver.findElement(rememberme).click();
    	driver.findElement(loginbutton).click();
        
    }
	
    
	
	//-----Sub-Method Entering  user name ------

    public void fillUserName(String strUserName){

    	
    	driver.findElement(username).sendKeys(strUserName);
        
    }
	
  //-----Sub-Method Entering  password ------

    public void fillUserPwd(String strPassword){

    	driver.findElement(password).sendKeys(strPassword);

        
    }
    
  //-----Sub-Method Un-check Remember Me ------

    public void RememberMe(){

    	driver.findElement(rememberme).click();

        
    }
    
    
  //-----Sub-Method Click on submit button ------

    public void clicklogin(){

    	driver.findElement(loginbutton).click();

        
    }
    
    
    
}
