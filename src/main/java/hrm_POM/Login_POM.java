package hrm_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_POM {

	//xpath of all webElements by annotation 
		@FindBy(xpath="//input[@name='username']")
		private WebElement username;
		
		@FindBy(xpath="//input[@name='password']")
		private WebElement password;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement loginButton;
		
		//Constructor to initialize elements 
		public Login_POM(WebDriver driver)
		{
			PageFactory.initElements(driver, this);		
		}
		
		//method of WebElement 
		public void enterUserName(String user)
		{
			username.sendKeys(user);
		}
		
		public void enterPassword(String pass)
		{
			password.sendKeys(pass);
		}
		
		public void clickLogin()
		{
			loginButton.click();
		}
		
		public void clearuser()
		{
			username.clear();
		}
		public void clearpass()
		{
			password.clear();
		}


	
	
}
