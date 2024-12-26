package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsEx {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//Switch to alert and accept
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		//Switch to alert and dismiss
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		//Switch to alert and sendKeys
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Deepu");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

}
