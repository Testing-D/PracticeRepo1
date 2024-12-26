package Selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAssg {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bus.irctc.co.in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Get the parent window id
		String mainwindow = driver.getWindowHandle();
		System.out.println("Parent Window Id is:" + mainwindow);
		//System.out.println("Parent title is: " + driver.getTitle());
		
		//click on flights, hotels, 
		driver.findElement(By.xpath("//span[text()='Flights']")).click();
		driver.findElement(By.xpath("//span[text()=' Hotels']")).click();
		driver.findElement(By.xpath("//span[text()='Retiring Room']")).click();
		
		//get the child window
		//Set<String> childWindow = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
		
		//Switch to window and Get window title
		for(int i=0;i<allWindows.size();i++) {
			String WindowId = allWindows.get(i);
			if(!mainwindow.equals(WindowId)) {
				driver.switchTo().window(WindowId);
				System.out.println("Windown Id is: " +driver.getWindowHandle());
				System.out.println("Window Title is: " +driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		//driver.quit();
	}
}
