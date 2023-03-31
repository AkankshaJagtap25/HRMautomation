package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	
	public static String capturePageScreenShot(WebDriver driver) throws IOException
	{
	
		String s = System.getProperty("user.dir");
		System.out.println(s);
		TakesScreenshot t = ((TakesScreenshot)driver);
		String path = s+"\\test-output\\ScreenShots\\"+System.currentTimeMillis()+".png";
		File Source = t.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileHandler.copy(Source, destination);
		return path;
	}

}
