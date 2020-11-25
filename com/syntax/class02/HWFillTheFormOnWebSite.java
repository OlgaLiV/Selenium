package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWFillTheFormOnWebSite {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 2");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		driver.manage().window().maximize();
		driver.findElement(By.id("customer.firstName")).sendKeys("Olga");
		driver.findElement(By.id("customer.lastName")).sendKeys("Liv");
		driver.findElement(By.id("customer.address.street")).sendKeys("qqqqqqqq");
		driver.findElement(By.name("customer.address.city")).sendKeys("Kiev");
		driver.findElement(By.id("customer.address.state")).sendKeys("Kiev");
		driver.findElement(By.name("customer.address.zipCode")).sendKeys("02095");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("347-422-6666");
		driver.findElement(By.id("customer.ssn")).sendKeys("333-333-33-33");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.username")).sendKeys("OlgaLiV");
		driver.findElement(By.id("customer.password")).sendKeys("A12345B");
		driver.findElement(By.id("repeatedPassword")).sendKeys("A12345B");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
