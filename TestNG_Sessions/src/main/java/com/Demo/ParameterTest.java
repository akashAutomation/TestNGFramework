package com.Demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	/*
	 * 1. using @Parameters annotation we can pass parameters using testng.xml 
	 * 2. parameters name should be exact as parameters present in testng.xml otherwise throw org.testng.TestNGException: Parameter 'xyz' is required by @Test on method ....
	 * 3. We can mostly use this feature to set the env. or configurations. For test data purpose excel file is better than this.
	 * 4. If you want to run the test without always providing parameter, use @Optional to avoid dependency on XML.


     */
	WebDriver driver;
	
	@Test
	@Parameters({"url","firstName","lastName"})
	public void parameterTest(@Optional("https://default.com") String url, String firstName, String lastName) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    //maximize window
	    driver.manage().deleteAllCookies();     //delete all the cookies
	        
	    //dynamic wait
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get(url);
	    
	    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);  
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        
        driver.quit();
	}
	
	@DataProvider()
	public Object[] c() {
		String[] data = {"x","y","z"};
		return data;
	}
	
}
