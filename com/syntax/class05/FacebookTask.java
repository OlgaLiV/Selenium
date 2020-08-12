package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTask {
	public static String url = "https://www.facebook.com/r.php";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.xpath("//input[@id = 'u_0_n']")).sendKeys("Julia");
		driver.findElement(By.id("u_0_p")).sendKeys("Roberts");
		driver.findElement(By.cssSelector("input[id = 'u_0_s']")).sendKeys("rudenko_a@inbox.ru");
		driver.findElement(By.id("u_0_v")).sendKeys("rudenko_a@inbox.ru");
		driver.findElement(By.xpath("//input[@id = 'password_step_input']")).sendKeys("12345Test");

		WebElement monthDD = driver.findElement(By.id("month"));
		Select selectMonth = new Select(monthDD);

		List<WebElement> optionsMonth = selectMonth.getOptions();
		int sizeMonth = optionsMonth.size();
		System.out.println(sizeMonth);
		if (sizeMonth - 1 == 12) {
			selectMonth.selectByVisibleText("Oct");
		}
		Thread.sleep(1000);

		WebElement dayDD = driver.findElement(By.id("day"));
		Select selectDay = new Select(dayDD);
		List<WebElement> optionsDay = selectDay.getOptions();
		int sizeDay = optionsDay.size();
		if (sizeDay - 1 == 31) {
			selectDay.selectByVisibleText("28");
		}
		Thread.sleep(1000);

		WebElement yearDD = driver.findElement(By.id("year"));
		Select selectYear = new Select(yearDD);
		List<WebElement> optionsYear = selectYear.getOptions();
		int sizeYear = optionsYear.size();
		System.out.println(sizeYear);
		if (sizeYear == 117) {
			selectYear.selectByVisibleText("1967");
		}
		Thread.sleep(1000);

		List<WebElement> buttons = driver.findElements(By.xpath("//input[@name = 'sex']"));
		for (WebElement optionButtons : buttons) {
			if (optionButtons.isEnabled()) {
				String sexButton = optionButtons.getAttribute("value");
				if (sexButton.equals("1")) {
					optionButtons.click();
					break;
				}
			}
		}
		Thread.sleep(1000);

		driver.findElement(By.id("u_0_14")).click();
		Thread.sleep(5000);
		driver.quit();

	}
}
