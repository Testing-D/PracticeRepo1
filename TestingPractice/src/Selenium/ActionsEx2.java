package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsEx2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		WebElement enabled = driver.findElement(By.xpath("//li[@id='ui-id-3']/a"));
		WebElement downloads = driver.findElement(By.xpath("//li[@id='ui-id-4']/a"));
		WebElement excel = driver.findElement(By.xpath("//li[@id='ui-id-7']/a"));
		
		a.moveToElement(enabled).pause(2000).moveToElement(downloads).pause(2000).moveToElement(excel).click().build().perform();
		
	}

}
