package com.testng.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGProgram {
	WebDriver driver;
	
	@BeforeMethod
	public void lauchbrowser() {
		WebDriverManager.chromedriver().setup();
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
	
	@Test(priority = 2, groups= {"SanityTest"})
	public void FramesEx() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//switch to frame
		driver.switchTo().frame("mce_0_ifr");
		
		String text = driver.findElement(By.xpath("//body[@id='tinymce']")).getText();
		System.out.println("iFrame Text is: " + text);
		
		//Come out of all the frames
		driver.switchTo().defaultContent();
		
		Assert.assertEquals(text, "Your content goes here.");
	}
	
	@Test(priority = 1, dependsOnMethods = "FramesEx", groups= {"Regression Test"})
	public void PositionEx() {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("-----Position Details-----");
		System.out.println(driver.manage().window().getPosition());
		System.out.println(driver.manage().window().getPosition().getX());
		System.out.println(driver.manage().window().getPosition().getY());
		
		System.out.println("-----Size Details-----");
		System.out.println(driver.manage().window().getSize());
		System.out.println(driver.manage().window().getSize().getWidth());
		System.out.println(driver.manage().window().getSize().getHeight());
		
		//Set browser into other position and size
		Point p = new Point(500, 500);
		driver.manage().window().setPosition(p);
		
		Dimension d = new Dimension(500, 500);
		driver.manage().window().setSize(d);
	}

}
