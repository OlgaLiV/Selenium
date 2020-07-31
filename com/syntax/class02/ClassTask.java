package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Web Orders";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("This is right title");
		} else {
			System.out.println("This is wrong title");
		}

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_logout")).click();
		driver.quit();

	}
}
