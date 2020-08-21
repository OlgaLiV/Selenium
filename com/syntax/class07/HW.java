package com.syntax.class07;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	
	public static String url = "https://demoqa.com/browser-windows";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String mainPageHandle = driver.getWindowHandle();
		WebElement newTabButton = driver.findElement(By.id("tabButton"));
		newTabButton.click();
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
		}
		WebElement firstTab = driver.findElement(By.id("sampleHeading"));
		System.out.println(firstTab.getText());
		
		driver.switchTo().window(mainPageHandle);
		
		WebElement newWindowButton = driver.findElement(By.id("windowButton"));
		newWindowButton.click();
		
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String window : allWindows1) {
			driver.switchTo().window(window);
		}
		
		WebElement secondWindow = driver.findElement(By.id("sampleHeading"));
		System.out.println(secondWindow.getText());
		driver.switchTo().window(mainPageHandle);
		
		WebElement newMessageWindow = driver.findElement(By.id("messageWindowButton"));
		newMessageWindow.click();
		
		Set<String> messageWindow = driver.getWindowHandles();
		for(String message:messageWindow) {
			driver.switchTo().window(message);
		}
		
//		WebElement messageText = driver.findElement(By.xpath("/html/body"));
//		System.out.println(messageText.getText());
		driver.switchTo().window(mainPageHandle);
		
		WebElement title = driver.findElement(By.xpath("//img[@src = '/images/Toolsqa.jpg']"));
		if(title.isDisplayed()) {
			System.out.println(driver.getTitle());
		}
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
		
		

}
}
