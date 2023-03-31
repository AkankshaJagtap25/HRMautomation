package hrm_TEST;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testUtility.ScreenShot;
import testUtility.StaticBrowser;

public class BaseClass {
	
	static WebDriver driver;
	public static ExtentReports report;
	public static ExtentHtmlReporter extent;
	public static ExtentTest logger;
		
	
	@Parameters({"browserN"})
	@BeforeTest
	public void beforeTest(String browser)
	{	
		WebDriver driver = StaticBrowser.openBrowser(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	
		report = new ExtentReports();
		extent = new ExtentHtmlReporter("test-output\\Report\\"+System.currentTimeMillis()+".html");
		report.attachReporter(extent);
		
		}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=ScreenShot.capturePageScreenShot(driver);
			
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		}
		
		report.flush();
		
	}
	
	
	

}
