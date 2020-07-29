package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTask {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https:www.amazon.com");
		System.out.println(driver.getCurrentUrl());		
		System.out.println(driver.getTitle());
		
		
		
	}
}
