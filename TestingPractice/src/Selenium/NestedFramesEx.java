package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesEx {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//switch to frame
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		//perform operations
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		//perform operations
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		//perform operations
		
		driver.switchTo().defaultContent();
		
		//Switch to frame
		driver.switchTo().frame("frame-bottom");
		//Perform operations
		
		driver.switchTo().defaultContent();
		
		//Screenshot
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(".\\src\\screen1.png"));
	}
}
