package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {
	
	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.switchTo().frame(0);
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("Batch7");
		
		driver.switchTo().defaultContent(); // go back to main page
		
		WebElement clickOnText = driver.findElement(By.xpath("//h3[text()='click on the below link: ']"));
		String text = clickOnText.getText();
		System.out.println(text);
		
		driver.switchTo().frame("iframe_a");
		textBox.clear();
		textBox.sendKeys("Syntax");
		
		driver.switchTo().defaultContent();
		
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));
		driver.switchTo().frame(iFrame);
		textBox.clear();
		textBox.sendKeys("Wassup");

}
}
