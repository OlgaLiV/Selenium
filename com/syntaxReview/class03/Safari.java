package com.syntaxReview.class03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari {
	public static void main(String[] args) {
		
	
	
	WebDriver driver = new SafariDriver();
	driver.get("http://google.com");
	
	}
}
