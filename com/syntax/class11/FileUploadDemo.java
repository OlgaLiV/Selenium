package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {
	public static String url = "http://the-internet.herokuapp.com/";

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement fileUpload = driver.findElement(By.linkText("File Upload"));
		fileUpload.click();
		
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		chooseFile.sendKeys("/Users/alexandrrudenko/eclipse-workspace/JavaBasics/testdata/SampleTestData.xlsx");
		
		WebElement submitButton = driver.findElement(By.id("file-submit"));
		submitButton.click();
	}

}
