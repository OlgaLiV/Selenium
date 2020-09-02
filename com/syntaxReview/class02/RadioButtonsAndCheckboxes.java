package com.syntaxReview.class02;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsAndCheckboxes {
	public static String url = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		// 1-st way
		WebElement femaleBtn = driver.findElement(By.xpath("//input[@value = 'Female' and @name = 'optradio']"));
		Thread.sleep(2000);
		//femaleBtn.click();
		//System.out.println("Is female button is selected: " + femaleBtn.isSelected());
		WebElement checkBtn = driver.findElement(By.id("buttoncheck"));
		checkBtn.click();
		String text = driver.findElement(By.cssSelector("p.radiobutton")).getText();
//		if (text.contains("Female")) {
//			System.out.println("Female button selection test PASS");
//		} else {
//			System.out.println("Female button selection test FAIL");
//		}
		
		// 2-nd way
		List<WebElement> gender = driver.findElements(By.cssSelector("input[name= 'optradio']"));
		for (WebElement btn : gender) {
			btn.click();
			checkBtn.click();
			String buttonText = btn.getAttribute("value");
			if(text.contains(buttonText)) {
				System.out.println(buttonText + " selection test PASS");
			}else {
				System.out.println(buttonText + " selection test FAIL");
			}
			Thread.sleep(2000);
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}
