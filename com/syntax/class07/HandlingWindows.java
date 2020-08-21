package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {
	public static String url = "http://166.62.36.207/syntaxpractice/window-popup-modal-demo.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		String mainPageHandle = driver.getWindowHandle();
		
		WebElement instaButton = driver.findElement(By.linkText("Follow On Instagram"));
		WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
		WebElement instaAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));
		instaButton.click();
		fbButton.click();
		instaAndFbButton.click();
		Thread.sleep(2000);
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		Iterator<String> it = allWindows.iterator();
		while(it.hasNext()) {
			String childHandle = it.next();
			if(!childHandle.equals(mainPageHandle)) {
			driver.switchTo().window(childHandle);
			System.out.println(driver.getTitle());
			driver.close();
			}
		}
		driver.switchTo().window(mainPageHandle);
		instaButton.click();
		

}
}
