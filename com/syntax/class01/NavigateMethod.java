package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		Thread.sleep(3000); // paused for 3 sec
		// driver.navigate().to("http://facebook.com"); // opens google and then fb in
		// one tab
//		driver.navigate().back();
//		driver.navigate().forward();		
		driver.navigate().refresh(); // refresh the page
		Thread.sleep(3000);
//		
//		driver.manage().window().maximize(); // to maximize screen
		driver.close(); // to close browser
//		driver.quit(); // quit will close all tabs(like red cross)
//		

	}
}
