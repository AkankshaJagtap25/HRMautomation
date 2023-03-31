package hrm_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_POM {
	
	@FindBy(xpath="//span[@class=\"oxd-userdropdown-tab\"]")
	private WebElement profile;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement Admin;
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement PIM;
	
	@FindBy(xpath="//span[text()='Leave']")
	private WebElement Leave;
	
	@FindBy(xpath="//span[text()='Time']")
	private WebElement Time;
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement Recruitment;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement My_Info;
	
	@FindBy(xpath="//span[text()='Performance']")
	private WebElement Performance;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement Dashboard;
	
	@FindBy(xpath="//span[text()='Directory']")
	private WebElement Directory;
	
	@FindBy(xpath="//span[text()='Maintenance']")
	private WebElement Maintenance;
	
	@FindBy(xpath="//span[text()='Buzz']")
	private WebElement Buzz;
	
	//constructor
	public Home_POM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	
	//methods
	public boolean isDisp()
	{
		boolean b = profile.isDisplayed();
		return b; 
	}
	
	
	

}
