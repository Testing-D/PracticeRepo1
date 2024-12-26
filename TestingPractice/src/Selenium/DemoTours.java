package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoTours {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Register
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		
		//Enter firstName (name locator)
		driver.findElement(By.name("firstName")).sendKeys("Deepu");
		
		//Enter lastName (xpath)
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("K");
		
		//Enter Phone (CSS Syntax)
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("1234567890");
		
		//Enter Email (id locator)
		driver.findElement(By.id("userName")).sendKeys("deepudeepika164@gmail.com");
		
		//Enter Address (Identify from its parent using direct xpath)
		driver.findElement(By.xpath("//form[@method='post']/table/tbody/tr[7]/td[2]/input")).sendKeys("Hyd");
		
		//Enter City (identify from its parent using indirect xpath)
		driver.findElement(By.xpath("//form[@method='post']//tr[8]/td[2]/input")).sendKeys("Hyd");
		
		//Enter State (using city identify state (child to parent))
		driver.findElement(By.xpath("//input[@name='city']/parent::td/parent::tr/following-sibling::tr/td/input[@name='state']")).sendKeys("telangana");
		
		//Enter Postal Code
		driver.findElement(By.xpath("//input[@name='state']/parent::td/../following-sibling::tr//input[@name='postalCode']")).sendKeys("500019");
		
		//Work with dropdown for select tag
		Select s = new Select(driver.findElement(By.name("country")));
		List<WebElement> options = s.getOptions();
		
		//Get All options from dropdrop
		for(int i=0;i<options.size();i++) {
			System.out.println("Country Text is:" + options.get(i).getText());
	}
		
		//Select value from dropdown
		s.selectByIndex(10);
		s.selectByValue("ALGERIA");
		s.selectByVisibleText("ARGENTINA");
		
		//Enter UserName
		driver.findElement(By.id("email")).sendKeys("Deepu");
		
		//Enter Password
		driver.findElement(By.name("password")).sendKeys("deepu");
		
		//Enter Confirm Password
		driver.findElement(By.name("confirmPassword")).sendKeys("deepu");
		
		//Click on Submit Button
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		//Click on Flights
		driver.findElement(By.xpath("//a[text()='Flights']")).click();
		
		//Click on radio button of oneway
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		
		//GetAttribute of radio button method
		String val = driver.findElement(By.xpath("//input[@value='Business']")).getAttribute("name");
		System.out.println("Radio Attribute Value is:" + val);
	}
}

