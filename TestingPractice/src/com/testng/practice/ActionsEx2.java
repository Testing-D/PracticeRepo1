package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsEx2 {
	WebDriver driver;
	
	@BeforeMethod
	public void lauchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}

	@Test
	public void ActionEx2() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		WebElement enabled = driver.findElement(By.xpath("//li[@id='ui-id-3']/a"));
		WebElement downloads = driver.findElement(By.xpath("//li[@id='ui-id-4']/a"));
		WebElement excel = driver.findElement(By.xpath("//li[@id='ui-id-7']/a"));
		
		a.moveToElement(enabled).pause(2000).moveToElement(downloads).pause(2000).moveToElement(excel).click().build().perform();
		
	}

}
