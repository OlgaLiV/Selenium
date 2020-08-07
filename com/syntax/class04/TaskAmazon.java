package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskAmazon {
	public static String url = "http://amazon.com";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());

		for (WebElement links : allLinks) {
			String linkText = links.getText();
			String fullLink = links.getAttribute("href");
			if (!linkText.isEmpty()) {
				System.out.println(linkText + "   " + fullLink);
			}
		}
	}
}
