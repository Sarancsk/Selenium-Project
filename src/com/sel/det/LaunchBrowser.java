package com.sel.det;



import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LaunchBrowser {

	public static void main(String[] args) throws Exception  {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.tagName("table"));
		List<WebElement> tRows = table.findElements(By.tagName("tr"));
		for (int i=0; i<tRows.size(); i++) {
			WebElement row = tRows.get(i);
			List<WebElement> tData = row.findElements(By.tagName("td"));
			for (int j=0; j<tData.size(); j++) {
				WebElement data =tData.get(j);
				String text = data.getText();
				System.out.println(text);
			}
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target =new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\Screenshot.png");
		FileUtils.copyFile(source, target);
		
		
	     
		
		
		

		
		
	
	}	
}
