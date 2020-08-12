package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayTask {
	public static String url = "https://www.ebay.com/";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement allCategories = driver.findElement(By.id("gh-cat"));
		Select select = new Select(allCategories);

		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			String text = option.getText();
			System.out.println(text);
		}
		System.out.println("******************");

		select.selectByValue("58058");
		driver.findElement(By.id("gh-btn")).click();

		String actualText = driver.findElement(By.xpath("//span[@class = 'b-pageheader__text']")).getText();
		String expectedText = "Computers, Tablets & Network Hardware";
		if (actualText.equals(expectedText)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
		driver.quit();

	}

}
