package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask {

	public static String url = "http://166.62.36.207/syntaxpractice/bootstrap-iframe.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.switchTo().frame("FrameOne");

		WebElement logo = driver.findElement(By.xpath("//img[@id = 'hide']"));
		boolean isLogoDisplayed = logo.isDisplayed();
		System.out.println("Is logo is displayed? " + isLogoDisplayed);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("FrameTwo");
		WebElement button = driver.findElement(By.xpath("//a[text() = 'Enroll Today']"));
		boolean isEnabled = button.isEnabled();
		System.out.println("Is button is here? " + isEnabled);
		
		driver.switchTo().defaultContent();
		driver.quit();

	}
}
