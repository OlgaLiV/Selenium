package com.syntaxReview.class03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleTables {
	public static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employee List")));
		driver.findElement(By.linkText("Employee List")).click();

		String[] headers = { "Id", "First (& Middle) Name", "Last Name", "Job Title", "Employment Status", "Sub Unit",
				"Supervisor" };
		List<WebElement> listOfHeader = driver.findElements(By.xpath("//table[@id = 'resultTable']/thead/tr/th"));

		int i = 1;
		for (String header : headers) {
			if (header.equals(listOfHeader.get(i).getText())) {
				System.out.println(listOfHeader.get(i).getText());
				System.out.println(header + " test pass");
				i++;
			} else {
				System.out.println(header + " test fail");
			}
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//table[@id = 'resultTable']/thead/tr/th[3]")).click();

		Thread.sleep(4000);

		driver.quit();

	}
}
