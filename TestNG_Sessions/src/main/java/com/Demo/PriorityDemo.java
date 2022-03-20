package com.Demo;

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
	 * 1. Test cases will be executed according to it's priority.
	 * 2. test cases which have same priority will be executed in alphabetical order.
	 * 3. test case which have priority = 0 will be executed first means before the all test cases which have other priorities.
	 * 4. All test cases which do not have any priority will be executed first in alphabetical order before the all other case which have priority.
	 *    ex-> ABC -> Abc -> Test4 -> abc -> test3 -> Test1 -> test1 -> enterName -> getTitle -> test2
	 * 
	 * 5. All test cases which starts with capital letters are executed first before the all test cases which starts with small letter. Same 
	 *    apply with prioritized test cases
	 *    ex -> ABC -> Abc -> Test4 -> abc 
	 */	
	WebDriver driver;
	
	@BeforeTest
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();    //maximize window
	    driver.manage().deleteAllCookies();     //delete all the cookies
	        
	    //dynamic wait
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	@AfterMethod()
	public void closeBrowser() {
		driver.quit();
	}
}
