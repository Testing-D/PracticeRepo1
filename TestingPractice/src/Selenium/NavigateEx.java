package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateEx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		driver.findElement(By.xpath("//span[text()='Documentation']")).click();
		driver.findElement(By.xpath("//span[text()='Projects']")).click();
		
		driver.navigate().to("https://www.selenium.dev/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

}
