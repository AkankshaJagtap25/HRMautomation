package hrm_TEST;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import hrm_POM.Home_POM;
import hrm_POM.Login_POM;
import testUtility.ReadFileData;

public class LoginTestCase extends BaseClass {
	
	

	//WebDriver driver;
	Login_POM login;
	Home_POM home;
	SoftAssert s;
	ReadFileData r;

	@BeforeClass
	public void beforeClass() 
	{
		login = new Login_POM(driver);
	
		home = new Home_POM(driver);
		
//		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		s = new SoftAssert();		
		
	}

	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("Before Method");
	}

	@Test(priority =0 )
	public void VerifyLoginWithcorrectData() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger = report.createTest("Verify login functionality with valid data");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login.enterUserName(r.fetchDataFromExcel(1, 0));
		login.enterPassword(r.fetchDataFromExcel(1, 1));
		login.clickLogin();
		
		String expResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actResult = driver.getCurrentUrl();

		s.assertEquals(expResult, actResult);
		s.assertAll();
		
	}
	
	@Test(priority = 1)
	public void VerifyLoginWithIncorrectData() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger = report.createTest("Verify login functionality with Invalid data");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().back();
		login.clearuser();
		login.clearpass();
		login.enterUserName(r.fetchDataFromExcel(2, 0));
		login.enterPassword(r.fetchDataFromExcel(2, 1));
		login.clickLogin();
		Thread.sleep(3000);
		String expResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actResult = driver.getCurrentUrl();

		s.assertNotEquals(expResult, actResult);
		s.assertAll();
	System.out.println("Just for git ");
		logger.pass("Test case is pass");
		
	}
	
	@Test(dependsOnMethods = {"VerifyLoginWithcorrectData"})
	public void verifyisDisp()
	{
		logger = report.createTest("Verify WebElement is displyed or not");
		
		boolean b1 = home.isDisp();

		Assert.assertTrue(b1);	
		
	}
		
//	@Test
//	public void test1() throws InterruptedException 
//	{
//		
//		login.enterUserName("Admin");
//		login.enterPassword("admin123");
//		login.clickLogin();
//		String expResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
//		String actResult = driver.getCurrentUrl();
//
//		s.assertEquals(expResult, actResult);
//		s.assertAll();
//
//		boolean b1 = home.isDisp();
//
//		Assert.assertTrue(b1);		
//	}

	
//	@Test
//	public void test3() throws InterruptedException 
//	{	
//		driver.navigate().back();
//		a1.clruser();
//		a1.clrpass();
//		Thread.sleep(3000);
//	
//		a1.enterUserName("Admin1");
//		a1.enterPassword("admin1234");
//		a1.clickLogin();
//
//		String expResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
//		String actResult = driver.getCurrentUrl();
//		s.assertNotEquals(actResult, expResult);
//
//	}

	

	

}
