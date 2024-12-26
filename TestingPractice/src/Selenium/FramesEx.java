package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesEx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//switch to frame
		driver.switchTo().frame("mce_0_ifr");
		
		String text = driver.findElement(By.xpath("//body[@id='tinymce']")).getText();
		System.out.println("iFrame Text is: " + text);
		
		//Come out of all the frames
		driver.switchTo().defaultContent();
	}

}
