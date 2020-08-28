package com.syntax.class10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkMix {
	public static String url = "https://artoftesting.com/samplesiteforselenium";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String simpleText = driver.findElement(By.xpath("//p[text() = 'This is sample text!']")).getText();
		System.out.println(simpleText);
		String mainPage = driver.getWindowHandle();
		WebElement link = driver.findElement(By.xpath("//a[text() = 'This is a link']"));
		link.click();
		Set<String> allWind = driver.getWindowHandles();
		Iterator<String> it = allWind.iterator();
		mainPage = it.next();
		String childPage = it.next();
		driver.switchTo().window(mainPage);

		WebElement textBox = driver.findElement(By.id("fname"));
		textBox.sendKeys("Hello world");

		WebElement submitButton = driver.findElement(By.id("idOfButton"));
		submitButton.click();

		Actions action = new Actions(driver);
		WebElement doubleClickButton = driver.findElement(By.id("dblClkBtn"));
		action.doubleClick(doubleClickButton).perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();		
		alert.accept();

		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type = 'radio']"));
		for (WebElement radioButton : radioButtons) {
			if (radioButton.isEnabled()) {
				String radioB = radioButton.getAttribute("value");
				if (radioB.equalsIgnoreCase("female")) {
					radioButton.click();
					break;
				}
			}
		}

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.isEnabled()) {
				String check = checkBox.getAttribute("value");
				if (check.equalsIgnoreCase("Performance")) {
					checkBox.click();
					break;
				}
			}
		}

		WebElement dD = driver.findElement(By.id("testingDropdown"));
		Select select = new Select(dD);

		List<WebElement> options = select.getOptions();
		Iterator<WebElement> iterator = options.iterator();
		while (iterator.hasNext()) {
			WebElement optionDD = iterator.next();
			select.selectByVisibleText("Manual Testing");
		}

		WebElement alertBoxGenerate = driver.findElement(
				By.xpath("//button[@onclick = 'if (!window.__cfRLUnblockHandlers) return false; generateAlertBox()']"));
		alertBoxGenerate.click();
		Thread.sleep(5000);
		Alert alert2 = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		alert2.accept();

		WebElement confirmAlertButton = driver.findElement(By.xpath("//button[text() = 'Generate Confirm Box']"));
		confirmAlertButton.click();
		Thread.sleep(5000);
		Alert alert3 = driver.switchTo().alert();	
		wait.until(ExpectedConditions.alertIsPresent());
		alert3.dismiss();
		

		WebElement droppable = driver.findElement(By.xpath("//div[@id = 'targetDiv']"));
		WebElement draggable = driver.findElement(By.id("sourceImage"));
		// action.dragAndDrop(draggable, droppable).perform();

		action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
		Thread.sleep(2000);

		driver.quit();

	}

}
