package com.Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssertionDemo {
	WebDriver driver;
	
	@BeforeTest
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	
	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();    //maximize window
	    driver.manage().deleteAllCookies();     //delete all the cookies
	        
	    //dynamic wait
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void getTitle() {
		Assert.assertEquals(driver.getTitle(), "abc", "title is not matched");
	}
		
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
