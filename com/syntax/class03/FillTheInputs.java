package com.syntax.class03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillTheInputs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a#btn_basic_example")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a#btn_inter_example")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text() = 'Input Form with Validations']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@placeholder, 'First')]")).sendKeys("Jennifer");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name*= 'last']")).sendKeys("Aniston");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name^= 'email']")).sendKeys("JA@yahoo.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[starts-with(@name, 'phone')]")).sendKeys("111-111-1111");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name = 'address']")).sendKeys("9000 W. Sunset Blvd");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder*= 'city']")).sendKeys("Hollywood");
		Thread.sleep(1000);

		WebElement dropDown = driver.findElement(By.name("state"));
		Select dd = new Select(dropDown);
		dd.selectByIndex(5);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name = 'zip']")).sendKeys("90038");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name = 'website']")).sendKeys("http://jennifer-aniston.org/");
		Thread.sleep(1000);

		List<WebElement> radio = driver.findElements(By.name("hosting"));
		for (WebElement host : radio) {
			String str = host.getAttribute("value");
			if (str.equalsIgnoreCase("yes")) {
				host.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("textarea[name = 'comment']")).sendKeys("blablablablabla");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[class = 'btn btn-default']")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
