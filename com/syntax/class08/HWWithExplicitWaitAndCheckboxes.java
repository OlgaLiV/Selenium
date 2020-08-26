package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HWWithExplicitWaitAndCheckboxes {
	public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
		checkBox.click();

		WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
		removeButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'message']")));
		WebElement message = driver.findElement(By.xpath("//p[@id = 'message']"));
		String messageText = message.getText();
		System.out.println(messageText);

		WebElement enableButton = driver.findElement(By.xpath("//button[text() = 'Enable']"));
		enableButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'enabled')]")));
		WebElement enabledMessage = driver.findElement(By.xpath("//p[contains(text(), 'enabled')]"));
		String enabledText = enabledMessage.getText();
		System.out.println(enabledText);

		WebElement inputText = driver.findElement(By.xpath("//input[@type = 'text']"));
		inputText.sendKeys("Good morning world");
		WebElement disableButton = driver.findElement(By.xpath("//button[text() = 'Disable']"));
		disableButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'disabled')]")));
		WebElement disabledMessage = driver.findElement(By.xpath("//p[contains(text(), 'disabled')]"));
		String disableText = disabledMessage.getText();
		System.out.println(disableText);

		driver.close();

	}
}
