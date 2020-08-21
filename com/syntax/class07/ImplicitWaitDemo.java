package com.syntax.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {
		
		public static String url = "http://166.62.36.207/syntaxpractice/index.html";

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get(url);
			//set implicit wait for 20 seconds
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement homeButton = driver.findElement(By.xpath("//a[text() = 'Home']"));
			homeButton.click();
		
	}

}
