package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");  //navigate to google.com
		String url = driver.getCurrentUrl();// return current url address		
		System.out.println(url); 
		String title = driver.getTitle(); // return title
		System.out.println(title);
		
		

	}
}
