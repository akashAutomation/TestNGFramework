package com.Demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasicDemo {
	WebDriver driver;
	
	@BeforeTest //- Runs once before any test methods in the class.
    public void setProperty() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\driver\\chromedriver.exe");
	}
	
	@BeforeClass //- Runs before each @Test method.
    public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();    //maximize window
	    driver.manage().deleteAllCookies();     //delete all the cookies
	        
	    //dynamic wait
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void enterName() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("akash");  
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("gupta");
        
	}
	
	@Test
	public void getTitle() {
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
}	