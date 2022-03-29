package com.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.support.BaseController;

public class ParallelDemo extends BaseController{
	WebDriver driver;

//	@BeforeMethod
//	public void setup() {
//		System.out.println("setup "+Thread.currentThread().getId());
//		setProperty();
//		driver = new ChromeDriver();
//		//openBrowser();
//		
//	}
	
	@Test
	public void test1() {
		System.out.println("test 1 "+Thread.currentThread().getId());
		setProperty();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.quit();
	}
	
	@Test
	public void test2() {
		System.out.println("test 2 "+Thread.currentThread().getId());
		setProperty();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.quit();
	}
	
	@Test
	public void test3() {
		System.out.println("test 3 "+Thread.currentThread().getId());
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void test4() {
		System.out.println("test 4 "+Thread.currentThread().getId());
		setProperty();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.quit();
	}
//	
//	@Test
//	public void test5() {
//		System.out.println("test 5 "+Thread.currentThread().getId());
//
//	}
//	
//	@Test
//	public void test6() {
//		System.out.println("test 6 "+Thread.currentThread().getId());
//
//	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.quit();
	}
}
