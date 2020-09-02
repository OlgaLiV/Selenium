package com.syntax.class11;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigHomeWork {

	public static String url = "http://www.uitestpractice.com/Students/Index";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// table
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 0; i < rows.size(); i++) {
			String rowText = rows.get(i).getText();
			if(rowText.contains("Donald")) {
				WebElement column = driver.findElements(By.xpath("//tbody/tr/td[4]")).get(i-1);
				String textCol = column.getText();
				if(textCol.equals("DELETE")) {
					column.click();					
				}
				break;
			}
		}

		// AjaxCall
		WebElement ajaxLinkButton = driver.findElement(By.xpath("//a[text() = 'AjaxCall']"));
		ajaxLinkButton.click();
		WebElement ajaxLink = driver.findElement(By.xpath("//a[text() = 'This is a Ajax link']"));
		ajaxLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'ContactUs']")));
		String ajaxLinkText = driver.findElement(By.xpath("//div[@class = 'ContactUs']")).getText();
		System.out.println(ajaxLinkText);

		// Form
		WebElement formLinkButton = driver.findElement(By.xpath("//a[text() = 'Form']"));
		formLinkButton.click();
		WebElement firstName = driver.findElement(By.id("firstname"));
		firstName.sendKeys("Erin");
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("Brockovich");

		// radioButtons
		List<WebElement> radioButtons = driver.findElements(By.xpath("//label[@class = 'radio-inline']"));
		for (int i = 0; i < radioButtons.size(); i++) {
			String radioButtonText = radioButtons.get(i).getText();
			System.out.println(radioButtonText);
			if(radioButtonText.equalsIgnoreCase("Married")) {
				driver.findElements(By.xpath("//input[@name = 'optradio']")).get(i).click();
				break;
			}
		}
		
		// CheckBox
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		for (WebElement checkBox : checkBoxes) {
			if(checkBox.isEnabled()) {
				String checkBoxValue = checkBox.getAttribute("value");
				if(checkBoxValue.equalsIgnoreCase("read")) {
					checkBox.click();
					break;
				}
			}
		}
		
		// DropDowns
		
		WebElement countryDD = driver.findElement(By.id("sel1"));
		Select select = new Select(countryDD);
		select.selectByVisibleText("Dominican Republic ");
		
		// Calendar
		
		WebElement calendar = driver.findElement(By.id("datepicker"));
		calendar.click();
		
		WebElement month = driver.findElement(By.className("ui-datepicker-month"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Apr");
		
		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("1980");
		
		List<WebElement> days = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement day : days) {
			String dayText = day.getText();
			if(dayText.equals("20")) {
				day.click();
				break;
			}
		}
		
		// Else inputs
		
		WebElement phoneNumber = driver.findElement(By.id("phonenumber"));
		phoneNumber.sendKeys("9999999");
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("ErinB");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("erinbrockovich@gmail.com");
		
		WebElement aboutYourself = driver.findElement(By.id("comment"));
		aboutYourself.sendKeys("I love my life");
		
		WebElement password = driver.findElement(By.id("pwd"));
		password.sendKeys("1234567890");
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@class = 'btn btn-default ']"));
		String submitButtonText = submitButton.getText();
		System.out.println("Submit button text is: " + submitButtonText);
		submitButton.click();
		
		// Controls link
		
		WebElement controlsLink = driver.findElement(By.xpath("//a[text() = 'Controls']"));
		controlsLink.click();
		
		// Drag and Drop
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'ui-widget-content ui-draggable ui-draggable-handle']")));
		WebElement draggable = driver.findElement(By.xpath("//div[@class = 'ui-widget-content ui-draggable ui-draggable-handle']"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		
		//Double Click
		WebElement doubleClickButton = driver.findElement(By.name("dblClick"));
		action.doubleClick(doubleClickButton).perform();
		
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: " + alertText);
		alert.accept();
		
		// iFrame
		driver.switchTo().frame("iframe_a");
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("My name is...");
		driver.switchTo().defaultContent();
		
		// new Window open
		WebElement clickToWathcVideo = driver.findElement(By.xpath("//a[text() = 'Click here to watch videos on C#']"));
		clickToWathcVideo.click();
		String mainPage = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		mainPage = iterator.next();
		String childPage = iterator.next();
		driver.switchTo().window(childPage);
		System.out.println("Child page url is: " + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(mainPage);
		System.out.println("Main page url is: " + driver.getCurrentUrl());
		
		// Widgets
		WebElement widgetButtonLink = driver.findElement(By.xpath("//a[text() = 'Widgets']"));
		widgetButtonLink.click();
		WebElement chooseFile = driver.findElement(By.id("image_file"));
		chooseFile.sendKeys("/Users/alexandrrudenko/eclipse-workspace/JavaBasics/testdata/SampleTestData.xlsx");
		WebElement uploadButton = driver.findElement(By.xpath("//input[@type = 'button']"));
		String uploadButtonText = uploadButton.getText();
		System.out.println("Upload button text is: " + uploadButtonText);
		uploadButton.click();
		
		// Actions
		WebElement actionsButtonLink = driver.findElement(By.xpath("//a[text() = 'Actions']"));
		actionsButtonLink.click();	
		
		//Switch to
		WebElement switchToLink = driver.findElement(By.xpath("//a[text() = 'Switch to']"));
		switchToLink.click();
		
		WebElement simpleAlert = driver.findElement(By.id("alert"));
		simpleAlert.click();
		driver.switchTo().alert();
		System.out.println("Simple Alert text is: " + alert.getText());
		alert.accept();
		
		WebElement confirmAlert= driver.findElement(By.id("confirm"));
		confirmAlert.click();
		driver.switchTo().alert();
		System.out.println("Confirm Alert text is: " + alert.getText());
		alert.accept();
		
		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Hello alert");
		System.out.println("Prompt alert text is: " + alert.getText());
		alert.accept();
		
		WebElement launchModal = driver.findElement(By.xpath("//button[@data-target = '#myModal']"));
		launchModal.click();
		String modalText = driver.findElement(By.xpath("//div[@class = 'modal-body']")).getText();
		System.out.println(modalText);
		WebElement closeButton = driver.findElement(By.xpath("//button[@class = 'btn btn-default']"));
		closeButton.click();
		
		driver.switchTo().frame("iframe_a");
		WebElement inputText = driver.findElement(By.id("name"));
		inputText.sendKeys("Hello world");
		driver.switchTo().defaultContent();
		
		WebElement linkNewWindow = driver.findElement(By.xpath("//a[contains(text(), 'Opens ')]"));
		linkNewWindow.click();
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindow : allWindows) {
			driver.switchTo().window(childWindow);
		}
		System.out.println("Child window is: " + driver.getCurrentUrl());
		driver.switchTo().window(mainWindow);
		System.out.println("Main window is: " + driver.getCurrentUrl());
		
		//Select
		WebElement selectLinkButton = driver.findElement(By.xpath("//a[text() = 'Select']"));
		selectLinkButton.click();
		WebElement singleDropDown = driver.findElement(By.id("countriesSingle"));
		Select selectDD = new Select(singleDropDown);
		selectDD.selectByIndex(1);
		
		WebElement multiDD = driver.findElement(By.id("countriesMultiple"));
		Select multiSelect = new Select(multiDD);
		List<WebElement> multiDrop = multiSelect.getOptions();
		Iterator<WebElement> iteratorDD = multiDrop.iterator();
		while(iteratorDD.hasNext()) {
			WebElement option = iteratorDD.next();
			String optionText = option.getText();
			multiSelect.selectByVisibleText(optionText);
		}
		
		WebElement dropdownMenu = driver.findElement(By.id("dropdownMenu1"));
		dropdownMenu.click();
		List<WebElement> dropdownList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']"));
		for (WebElement dropdown : dropdownList) {
			String dropdownText = dropdown.getText();
			if(dropdownText.equalsIgnoreCase("England")) {
				dropdown.click();
				break;
			}
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);  // the screenshot is taken
		
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/HRMS/homework.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
