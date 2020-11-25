package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAndPassword {
	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement logo = driver.findElement(By.xpath("//img[@alt = 'OrangeHRM']"));
		if(logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		}else {
			System.out.println("Logo is NOT displayed");
		}
		

	}
}
