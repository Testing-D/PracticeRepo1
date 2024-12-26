package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableEx {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//wait until my table display
//		WebDriverWait exp = new WebDriverWait(driver, 20);
//		Wait.until(ExpectedConditions.visibilityOf("driver.findElements(By.xpath("//table[@id='table1']"))));
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
		
		for(int row=1;row<=rows.size();row++) {
			for(int col=1;col<=cols.size();col++) {
				String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + row + "]/td[" + col + "]")).getText();
				System.out.println("row is:" +row +", "+"col is:" +col +", " +"text is:" +text);
			}
		}

	}

}
