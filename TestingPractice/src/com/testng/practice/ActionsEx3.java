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

public class ActionsEx3 {
	WebDriver driver;
	
	@BeforeMethod
	public void lauchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}

	@Test(groups= {"Smoke"})
	public void ActionEx3() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Drag And Drop Mouse Operations
		driver.switchTo().frame(0);
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
		//Slider operation
		driver.findElement(By.xpath("//a[text()='Slider']")).click();
		driver.switchTo().frame(0);
		WebElement slidersource = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		a.dragAndDropBy(slidersource, 200, 0).build().perform();
		driver.switchTo().defaultContent();
	}

}
