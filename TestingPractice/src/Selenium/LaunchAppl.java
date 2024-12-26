package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchAppl {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		System.out.println("Current url is:" +driver.getCurrentUrl());
		System.out.println("The Title is:" +driver.getTitle());
		//driver.findElement(By.name("userName")).sendKeys("Deepika");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Deepu");
		Thread.sleep(3000);
		driver.close();
	}

}
