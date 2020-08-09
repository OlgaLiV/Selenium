package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		List<WebElement> optionRadioButtons = driver.findElements(By.xpath("//input[@name = 'optradio']"));
		for (WebElement sexRadioButton : optionRadioButtons) {
			if (sexRadioButton.isEnabled()) {
				String radioButton = sexRadioButton.getAttribute("value");
				if (radioButton.equals("Female")) {
					sexRadioButton.click();
					break;
				}
			}

		}
		List<WebElement> optionRadioButtons2 = driver.findElements(By.xpath("//input[@name = 'gender']"));
		for (WebElement sexRadioButton2 : optionRadioButtons2) {
			if(sexRadioButton2.isEnabled()) {}
			String radioButton2 = sexRadioButton2.getAttribute("value");
			if(radioButton2.equals("Female")) {
				sexRadioButton2.click();
				break;
			}
		}
		
		List<WebElement> ageButtons = driver.findElements(By.xpath("//input[@name = 'ageGroup']"));
		for (WebElement ageCheck : ageButtons) {
			String ageRadio = ageCheck.getAttribute("value");
			if(ageRadio.equals("15 - 50")) {
				ageCheck.click();
				Thread.sleep(1000);
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//button[text() = 'Get values']")).click();
		
		WebElement buttonGetValues = driver.findElement(By.cssSelector("p[class = 'groupradiobutton']"));
		if(buttonGetValues.isDisplayed()) {
			String resultText = buttonGetValues.getText();
			if(resultText.contains("Sex : Female") && resultText.contains("15 - 50")) {
				System.out.println("Input is correct");
			}else {
				System.out.println("Incorrect input");
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
