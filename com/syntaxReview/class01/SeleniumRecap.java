package com.syntaxReview.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRecap {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		WebElement departments = driver.findElement(By.xpath("//select[@id = 'searchDropdownBox']"));
		departments.click();
		
		Thread.sleep(2000);
		driver.close();
		
		
		
		
	}
}
