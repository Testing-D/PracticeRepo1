package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingEx {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Scrolling down
		for(int i=1;i<=10;i++) {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
		}
		
		//Scrolling up
		for(int i=1;i<=10;i++) {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-200)");
			Thread.sleep(2000);
		}
		
		
	}

}
