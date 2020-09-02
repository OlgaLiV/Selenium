package com.syntax.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.syntax.pages.DashbordPage;
import com.syntax.pages.LoginPageWithFindBy;
import com.syntax.utils.BaseClass;

public class LoginTestWithFindBy {

	public static void main(String[] args) throws IOException {
		BaseClass.setUp();

		LoginPageWithFindBy login = new LoginPageWithFindBy();
		DashbordPage dashboard = new DashbordPage();
		login.userNameTextBox.sendKeys("Admin");
		login.passwordTextBox.sendKeys("Hum@nhrm123");
		login.loginBtn.click();

		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenshots/HRMS/dashboard.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String adminText = dashboard.welcomeAdmin.getText();
		System.out.println(adminText);
		
		BaseClass.tearDown();

	}

}
