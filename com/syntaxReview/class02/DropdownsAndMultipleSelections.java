package com.syntaxReview.class02;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownsAndMultipleSelections {

	public static String url = "http://ebay.com";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//1st way
		WebElement departments = driver.findElement(By.id("gh-cat"));		
		Select select = new Select(departments);
		List<WebElement> options = select.getOptions();
		int numberOfOptions = options.size();
		System.out.println("Number of departments: " + numberOfOptions);
		
		Iterator<WebElement> dIt = options.iterator();
		while(dIt.hasNext()) {
			WebElement option = dIt.next();
			System.out.println(option.getText());
		}
		
		System.out.println("--------------------------------------");
		
		//select.selectByIndex(1);
		//select.selectByValue("293");
		//select.selectByVisibleText("Business & Industrial");
		
		//2nd way
		
		List<WebElement> departmentsList = driver.findElements(By.xpath("//div[@id = 'gh-cat-box']/select/option"));
//		for (WebElement dept : departmentsList) {
//			dept.click();
//			if(dept.isSelected()) {
//				System.out.println("Departments selection test PASS");
//			}else {
//				System.out.println("Departments selection test FAIL");
//			}
//			Thread.sleep(500);
//		}
		for (WebElement dept : departmentsList) {
			if(dept.getText().equals("Cell Phones & Accessories")) {
				dept.click();
				if(dept.isSelected()) {
					System.out.println(dept.getText() + " department is selected");
				}else {
					System.out.println("Test fail");
				}
				break;
			}
		}
		
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}
}
