package com.selenium.popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticePopUps {
	
	public static void main(String[] args) throws InterruptedException {
		try {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.flipkart.com/");
			Thread.sleep(3000);
			driver.manage().window().maximize();
			
			Thread.sleep(3000);
			driver.quit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
