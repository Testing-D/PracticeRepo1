package Selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsEx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Getting the parent window id
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent Window Id is: " + parentwindow);
		
		//Click on link to open windows.
		for(int i=1;i<=5;i++) {
			driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		}
		
		//Getting child windows
		Set<String> allwindows = driver.getWindowHandles();
		List<String> allWindowsLst = new ArrayList<String>(allwindows);
		
		//get all windows id
		for(int i=0;i<allwindows.size();i++) {
			System.out.println("All Windows id are: " + allWindowsLst.get(i));
		}
		
		//switch to each child windows and get the title
		for(int i=0;i<allwindows.size();i++) {
			String WindowId = allWindowsLst.get(i);
			if(!parentwindow.equals(WindowId)) {
				driver.switchTo().window(WindowId);
				System.out.println("Window title is: "+ driver.getTitle());
				//driver.close();
			}
		}
		
		//switch to parent window and close all windows
		driver.switchTo().window(parentwindow);
		driver.quit();
	}

}
