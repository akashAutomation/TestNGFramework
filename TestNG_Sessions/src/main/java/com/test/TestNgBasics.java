package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	/*
	 *  1. All test cases are independent to each other
	 *  2. If you want to depend test cases to each other then use dependsOnMethods method
	 */
	//Preconditions annotations --> starting with @Before
	
	@BeforeSuite
	public void setUp() {
		System.out.println("@BeforeSuite --> setup system property");
	}
	
	@BeforeTest	
	public void launchChrome() {
		System.out.println("@BeforeTest --> launch chrome");
	}
	
	@BeforeClass
	public void enterUrl() {
		System.out.println("@BeforeClass --> enter url");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("@BeforeMethod --> login");
	}
	
	// Test Cases --> starting with @Test
	@Test
	public void title() {
		System.out.println("@Test 1 --> title");
	}
	
	/*
	 * When there is more than 1 test case then the sequence of execution like this in pairs(total number of test) --> @BeforeMethod -> @Test -> @AfterMethod 
	 * 
	 * @BeforeMethod --> login	   
	   @Test 2 --> searchText
	   @AfterMethod --> logout
	   
       @BeforeMethod --> login
	   @Test 1 --> title
	   @AfterMethod --> logout
	 */
	
	@Test
	public void searchText() {
		System.out.println("@Test 2 --> searchText");
	}
	
	//Postconditions annotations --> starting with @After
	
	@AfterMethod
	public void logout() {
		System.out.println("@AfterMethod --> logout");
	}
	
	@AfterClass
	public void deleteCookies() {
		System.out.println("@AfterClass --> deleteCookies");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("@AfterTest --> closeBrowser");
	}
	
	@AfterSuite
	public void generateReport() {
		System.out.println("@AfterSuite --> generateReport");
	}
	
}
