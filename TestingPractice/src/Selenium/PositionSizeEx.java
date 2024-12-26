package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PositionSizeEx {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
