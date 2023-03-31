package testUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticBrowser {
	static WebDriver driver;
	public static WebDriver openBrowser(String browserN, String URL)
	{
		if(browserN.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		else if(browserN.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();			
		}
		else if(browserN.equalsIgnoreCase("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();			
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		
		return driver;
	}
	

}
