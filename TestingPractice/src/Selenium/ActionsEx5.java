package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsEx5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		
		WebElement multiselect = driver.findElement(By.id("selectable"));
		List<WebElement> multiselectitems = multiselect.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		Actions a = new Actions(driver);
		a.clickAndHold(multiselectitems.get(0)).moveToElement(multiselectitems.get(4)).release().build().perform();
		

	}

}
