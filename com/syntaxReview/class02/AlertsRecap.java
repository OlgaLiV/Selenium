package com.syntaxReview.class02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.utils.CommonMethods;

public class AlertsRecap extends CommonMethods {
	public static String url = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

		
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get(url);
	
	driver.findElement(By.linkText("Alerts & Modals")).click();
	driver.findElement(By.linkText("Javascript Alerts")).click();
	
	driver.findElement(By.xpath("//button[@onclick = 'myAlertFunction()']")).click();	
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	System.out.println(text);
	alert.accept();
	
	
	Thread.sleep(3000);
	driver.quit();
		
	}

}
