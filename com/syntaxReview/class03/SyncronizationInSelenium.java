package com.syntaxReview.class03;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncronizationInSelenium {

	public static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		// page loadTimeout. Works with get(url) and navigate().to(url)
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// define implicitWait for Selenium. Works with findElement() and findElements()
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// login on Orange HRM
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		// navigate to employee page

		// ExplicitWaits --> WebDriver Wait
		// create an object of WebDriverWait class
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// specify a condition for wait object
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee")));
		driver.findElement(By.linkText("Add Employee")).click();

		Thread.sleep(3000);
		driver.quit();
	}

}
