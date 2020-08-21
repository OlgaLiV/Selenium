package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTask {
	
	public static String url = "http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement firstAlertButton = driver.findElement(By.xpath("//button[@class = 'btn btn-default']"));
		firstAlertButton.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();

		WebElement secondButton = driver.findElement(By.xpath("(//button[@class = 'btn btn-default btn-lg'])[1]"));
		secondButton.click();
		Thread.sleep(2000);
		alert.accept();
		
		WebElement thirdButton = driver.findElement(By.xpath("(//button[@class = 'btn btn-default btn-lg'])[2]"));
		thirdButton.click();
		Thread.sleep(2000);
		
		alert.sendKeys("Olga");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(1000);
		
		
		
		
}
}
