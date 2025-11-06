package com.Demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriorityDemo {
	/*
	 * 1. Test cases will be executed according to its priority order.
	 * 2. test cases which have same priority will be executed in alphabetical order.
	 * 3. test case which have priority = 0 will be executed first means before the all test cases which have other positive priorities.
	 * 4. All test cases which do not have any priority will be executed first in alphabetical order before the all other case which have priority.
	 *    ex-> ABC -> Abc -> Test4 -> abc -> test3 -> Test1 -> test1 -> enterName -> getTitle -> test2
	 * 
	 * 5. All test cases which starts with capital letters are executed first before the all test cases which starts with small letter. Same 
	 *    apply with prioritized test cases
	 *    ex -> ABC -> Abc -> Test4 -> abc
	 *
	 * 6. priority only affects methods in the same class.
	 * 7. the priority value is an integer, and there is no fixed upper or lower limit — you can use any integer value, including negative numbers.
	 *    positive -> Commonly used (e.g., priority = 1, priority = 2)
	 *    zero -> Default if no priority is specified
	 *    negative -> Executes before zero and positive values



     */
	WebDriver driver;
	
	@BeforeTest
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\driver\\chromedriver.exe");
	}
	
	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();    //maximize window
	    driver.manage().deleteAllCookies();     //delete all the cookies
	        
	    //dynamic wait
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test(priority = 2)
	public void enterName() {
		System.out.println("enterName");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("akash");  
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("gupta");
	}
	
	@Test(priority = 3)
	public void getTitle() {
		System.out.println("getTitle = "+driver.getTitle());
	}
	
	@Test(priority = 1)
	public void test1() {
		System.out.println("test 1");
	}
	
	@Test(priority = 1)
	public void Test1() {
		System.out.println("Test 1");
	}
	
	@Test(priority = 3)
	public void test2() {
		System.out.println("test 2");
	}
	
	@Test(priority = 0)
	public void test3() {
		System.out.println("test 3");
	}
	
	@Test()
	public void abc() {
		System.out.println("abc");
	}
	
	@Test()
	public void Abc() {
		System.out.println("Abc");
	}
	
	@Test()
	public void Test4() {
		System.out.println("Test 4");
	}
	
	@Test()
	public void ABC() {
		System.out.println("ABC");
	}
	
	@AfterClass()
	public void closeBrowser() {
		driver.quit();
	}
}
