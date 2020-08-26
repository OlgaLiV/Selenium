package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalendarAmericanAirlines {
	public static String url = "https://www.aa.com/homePage.do?locale=en_US";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement cityFrom = driver.findElement(By.name("originAirport"));
		cityFrom.sendKeys("KBP");

		WebElement cityTo = driver.findElement(By.name("destinationAirport"));
		cityTo.sendKeys("JFK");

		WebElement departDateCalendar = driver.findElement(By.id("aa-leavingOn"));
		departDateCalendar.click();

		WebElement departureMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
		String depMonth = departureMonth.getText();
		WebElement next = driver.findElement(By.xpath("//a[@title = 'Next']"));

		while (!depMonth.equals("September")) {
			next.click();
			departureMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
			depMonth = departureMonth.getText();
		}

		List<WebElement> departureDates = driver
				.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement dDates : departureDates) {
			if (dDates.getText().equals("17")) {
				dDates.click();
				break;
			}
		}

		WebElement returnDateCalendar = driver.findElement(By.id("aa-returningFrom"));
		returnDateCalendar.click();

		WebElement returnMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
		String retMonth = returnMonth.getText();

		while (!retMonth.equals("December")) {
			WebElement next1 = driver.findElement(By.xpath("//a[@title = 'Next']"));
			next1.click();
			returnMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
			retMonth = returnMonth.getText();
		}

		List<WebElement> returnDates = driver
				.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement returnDate : returnDates) {
			if (returnDate.getText().equals("20")) {
				returnDate.click();
				break;
			}
		}

		WebElement submitButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
		submitButton.click();

		driver.quit();

	}
}
