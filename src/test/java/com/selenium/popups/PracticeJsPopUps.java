package com.selenium.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeJsPopUps {

	public static void main(String[] args) throws InterruptedException {
		try {

			WebDriverManager.chromedriver().setup();

			WebDriver driver = openBrowser();

			openUrl("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html", driver);

			clickAlertPopUp(driver);

			clickConfirmPopUp(driver);
			
			clickPromptPopUp(driver);
			
			Thread.sleep(3000);
			
			//setTextPromptPopUp(driver,"Aarya");  not working in chrome
			
			System.out.println("Alert PopUp Text : "+ getTextAlertPopUp(driver));
			
			System.out.println("Confirm PopUp Text : "+ getTextConfirmPopUp(driver));
			
			closeBrowser(driver);

		}

		catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	


	private static String getTextConfirmPopUp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
		Thread.sleep(3000);
		String str = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		

		return str;
	}

	private static String getTextAlertPopUp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
		Thread.sleep(3000);
		String str = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		return str;
	}

	private static WebDriver openBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private static void closeBrowser(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	private static void openUrl(String url, WebDriver driver) throws InterruptedException {
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		Thread.sleep(3000);
	}

	private static void clickAlertPopUp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

	}

	private static void clickConfirmPopUp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}
	
	private static void clickPromptPopUp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
	}
	
	private static void setTextPromptPopUp(WebDriver driver,String str) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys(str);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
	}


}
