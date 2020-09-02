package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;

public class LiginTest {
	public static void main(String[] args) {

		BaseClass.setUp();
		LoginPage loginPage = new LoginPage();
		loginPage.username.sendKeys("Admin");
		loginPage.password.sendKeys("Hum@nhrm123");
		loginPage.loginButton.click();

		BaseClass.tearDown();
	}

}
