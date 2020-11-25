package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2VerifingPassword {
	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type= 'submit']")).click();
		
		WebElement errMessage = driver.findElement(By.xpath("//span[@id= 'spanMessage']"));
		if(errMessage.isDisplayed()) {
			String message = errMessage.getText();
			if(message.equals("Password cannot be empty")) {
				System.out.println("You did task right");
			}else {
				System.out.println("You didn't pass task");
			}
		}
		
		driver.quit();
		
	}

}
