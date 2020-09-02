package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class DashbordPage extends BaseClass {
	
	@FindBy(css = "a#welcome")
	public WebElement welcomeAdmin;
	
	public DashbordPage() {
		PageFactory.initElements(driver, this);
	}

}
