package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsEx1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/menu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Actions - Used to perform Keyboard and mouse operations
		
		//Switch to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		//move to outer menu
		Actions a = new Actions(driver);
		WebElement elec = driver.findElement(By.id("ui-id-4"));
		WebElement Utilities = driver.findElement(By.id("ui-id-7"));
		a.moveToElement(elec).pause(2000).moveToElement(Utilities).pause(2000).click().build().perform();
		
	}

}
