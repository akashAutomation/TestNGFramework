package com.Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	/*
	 * 1. using @Parameters annotation we can pass parameters using testng.xml 
	 * 2. parameters name should be exact as parameters present in testng.xml otherwise it will pass default value as "param-val-not-found".
	 * 3. We can mostly use this feature to set the env. or configurations. For test data purpose excel file is better than this.   
	 */
	WebDriver driver;
	
	@Test
	@Parameters({"url","firstName","lastName"})
	public void parameterTest(String url, String firstName, String lastName) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    //maximize window
	    driver.manage().deleteAllCookies();     //delete all the cookies
	        
	    //dynamic wait
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(url);
	    
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);  
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        
        driver.quit();
	}
	
	@DataProvider()
	public Object c() {
		String[] data = {"x","y","z"};
		return data;
	}
	
}
