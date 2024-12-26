package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsEx4 {
	WebDriver driver;
	
	@BeforeMethod
	public void lauchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}

	@Test(groups= {"Regression Test"})
	public void ActionEx4() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("Indian Historical Places");
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER).build().perform();
	}

}
